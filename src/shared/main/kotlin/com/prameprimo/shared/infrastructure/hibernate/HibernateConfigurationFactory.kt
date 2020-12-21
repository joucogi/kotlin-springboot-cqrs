package com.prameprimo.shared.infrastructure.hibernate

import com.prameprimo.shared.domain.Service
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import org.springframework.core.io.support.ResourcePatternResolver
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import java.io.File
import java.util.*
import java.util.stream.Collectors
import javax.sql.DataSource

@Service
class HibernateConfigurationFactory(private val resourceResolver: ResourcePatternResolver) {

    fun hibernateTransactionManager(sessionFactory: LocalSessionFactoryBean): PlatformTransactionManager {
        val transactionManager = HibernateTransactionManager()
        transactionManager.sessionFactory = sessionFactory.getObject()
        return transactionManager
    }

    fun sessionFactory(contextName: String, dataSource: DataSource): LocalSessionFactoryBean {
        val sessionFactory = LocalSessionFactoryBean()
        sessionFactory.setDataSource(dataSource)
        sessionFactory.hibernateProperties = hibernateProperties()

        val mappingFiles: List<Resource> = searchMappingFiles(contextName)

        sessionFactory.setMappingLocations(*mappingFiles.toTypedArray())

        return sessionFactory
    }

    fun dataSource(
            host: String,
            port: Int,
            databaseName: String,
            username: String,
            password: String
    ): DataSource {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = "com.mysql.cj.jdbc.Driver"
        dataSource.url = String.format(
                "jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                host,
                port,
                databaseName
        )
        dataSource.username = username
        dataSource.password = password
        val mysqlResource = resourceResolver.getResource(String.format(
                "classpath:database/%s.sql",
                databaseName
        ))
        val mysqlSentences = Scanner(mysqlResource.inputStream, "UTF-8").useDelimiter("\\A").next()
        dataSource.setConnectionInitSqls(ArrayList(Arrays.asList(*mysqlSentences.split(";").toTypedArray())))
        return dataSource
    }

    private fun searchMappingFiles(contextName: String): List<Resource> {
        val modules: List<String> = subdirectoriesFor(contextName)
        val goodPaths: MutableList<String> = ArrayList()
        for (module in modules) {
            val files = mappingFilesIn("$module/infrastructure/persistence/hibernate/")
            for (file in files) {
                goodPaths.add("$module/infrastructure/persistence/hibernate/$file")
            }
        }
        return goodPaths.stream().map { path: String -> FileSystemResource(path) }.collect(Collectors.toList())
    }

    private fun subdirectoriesFor(contextName: String): List<String> {
        var path = "./src/$contextName/main/kotlin/com/prameprimo/$contextName/"
        var files = File(path).list { current: File?, name: String? -> File(current, name).isDirectory }
        if (null == files) {
            path = "./main/kotlin/com/prameprimo/$contextName/"
            files = File(path).list { current: File?, name: String? -> File(current, name).isDirectory }
        }
        if (null == files) {
            return emptyList()
        }
        val finalPath = path
        return Arrays.stream(files).map { file: String -> finalPath + file }.collect(Collectors.toList())
    }

    private fun mappingFilesIn(path: String): Array<String?> {
        return File(path).list { current: File, name: String ->
            File(current, name).name.contains(".hbm.xml")
        } ?: return arrayOfNulls(0)
    }

    private fun hibernateProperties(): Properties {
        val hibernateProperties = Properties()
        hibernateProperties[org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO] = "none"
        hibernateProperties[org.hibernate.cfg.AvailableSettings.SHOW_SQL] = "false"
        hibernateProperties[org.hibernate.cfg.AvailableSettings.DIALECT] = "org.hibernate.dialect.MySQL8Dialect"

        return hibernateProperties
    }
}
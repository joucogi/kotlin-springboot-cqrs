rootProject.name = "marketplace"

include(":shop")
project(":shop").projectDir = File("src/shop")

//include(":backoffice")
//project(":backoffice").projectDir = File("src/backoffice")

include(":shared")
project(":shared").projectDir = File("src/shared")
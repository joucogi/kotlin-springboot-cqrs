start_shop:
	@./gradlew bootRun --args='shop'

start_backoffice:
	@./gradlew bootRun --args='backoffice'

test:
	@./gradlew test --warning-mode all
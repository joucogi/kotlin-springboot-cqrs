.PHONY: build
build:
	@./gradlew build  --warning-mode all

start_shop:
	@./gradlew bootRun --args='shop'  --warning-mode all

start_backoffice:
	@./gradlew bootRun --args='backoffice'  --warning-mode all

test:
	@./gradlew test --warning-mode all

###########
##### CI
##########
ci-up:
	@docker-compose up -d

ci-test:
	@docker exec marketplace-app ./gradlew test --warning-mode all
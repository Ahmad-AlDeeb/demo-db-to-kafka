# Installation
1. Install [Python](https://www.python.org/downloads/).
2. Install pre-commit: `pip install pre-commit`
3. Install hooks from repo root: `pre-commit install --config ./config/.pre-commit-config.yaml`
5. Test hooks without committing: `pre-commit run --config ./config/.pre-commit-config.yaml --all-files`
# Installed Hooks
- **pre-commit hooks:**
	- trailing-whitespace.
	- end-of-file-fixer.
	- check-yaml.
- **Local hooks:**
	- maven-checkstyle (db-to-kafka)
	- maven-checkstyle (kafka-to-db)
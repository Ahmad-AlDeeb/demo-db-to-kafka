# Checkstyle IntelliJ Plugin Installation
1. Open plugins marketplace: `File > Settings > Plugins > Marketplace`.
2. Search for `Checkstyle-IDEA`, install it, and restart IntelliJ.
3. Open the plugin settings `File > Settings > Tools > Checkstyle`.
4. Change Scan Scope to `Only Java Sources (including tests)`.
5. Add new `Configuration File` by clicking `+` :
	1. Add description (e.g. `Sun Check (Custom)`).
	2. Browse and select following configuration file: `config/checkstyle/sun_checks_custom.xml`.
	3. Click `Next > Next > Finish`.
	4. Mark the new configuration.
6. Press `OK`.
7. Open the plugin (Usually left/bottom of the IDE).
8. Change rules to `Sun Check (Custom)`.
9. If the project is Spring, use `@SuppressWarnings("checkstyle:HideUtilityClassConstructor")` for entry point class (main).

# SonarLint IntelliJ Plugin Installation
1. Open plugins marketplace: `File > Settings > Plugins > Marketplace`.
2. Search for `SonarLint`, install it, and restart IntelliJ.

# Formatting
- Use IntelliJ Default formatting (Same as Checkstyle formatting with Sun Checks configuration).
- Hotkey: `CTRL + ALT + L`.


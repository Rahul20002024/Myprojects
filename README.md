# UserCRUDApp (Non-Maven Spring Boot)

This is a non-Maven Spring Boot project for User CRUD using H2 (in-memory). It contains:
- Plain Java source files
- `application.properties` configured for H2
- `scripts/` to fetch required JARs into `lib/` without using Maven/Gradle project structure

> ⚠️ Because this is **non-Maven**, you must download the dependency JARs first.

## 1) Download Dependencies (no Maven project needed)

### Option A: Windows PowerShell
```powershell
cd scripts
./get-libs.ps1
```

### Option B: Linux/Mac
```bash
cd scripts
chmod +x get-libs.sh
./get-libs.sh
```

This will download Spring Boot, Spring, Jackson, Hibernate, H2, SLF4J, Logback and other required JARs to `lib/`.

## 2) Import into Eclipse (as a plain Java project)
- File → Import → Existing Projects into Workspace
- Select the root directory of this folder.
- Right-click project → Properties → Java Build Path → Libraries → Add External JARs…
- Add **all** JARs from the `lib/` folder.

## 3) Run
- Right-click `com.inmakes.usercrud.UserCrudApplication` → Run As → Java Application
- Open: `http://localhost:8080/api/users` (GET)

H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:userdb`
- User: `sa`, Password: *(empty)*

## 4) Postman
Import `postman/UserCRUD.postman_collection.json` for ready-made requests & tests.

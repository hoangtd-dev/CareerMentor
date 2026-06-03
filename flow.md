```
                    ┌───────────────┐
                    │     Main      │
                    └───────────────┘
                            │
                            │ run()
                            ▼
          ┌──────────────────────────────────────────────────────┐
          │       UserManagementSystem                           │
          ├──────────────────────────────────────────────────────┤
          │ - fileDB   : FileDB                                  │
          │ - scanner  : ScannerUtils                            │
          │ - users    : List<User>                              │
          ├──────────────────────────────────────────────────────┤
          │ + run()                                              │
          │ - mappingUser()                                      │
          │ - updateDatabase()                                   │
          │ - showMenu()                                         │
          │ - showUserMenu()                                     │
          │ - register()                                         │
          │ - displayAllUsers()                                  │
          │ - searchByName()                                     │
          │ - viewUser()                                         │
          │ - login()                                            │
          │ - handleSelection()                                  │
          └──────────────────────────────────────────────────────┘
               │              │                             │
          uses │         uses │                        uses │
               ▼              ▼                             ▼
    ┌──────────────┐   ┌──────────────────────┐   ┌─────────────────────────┐
    │    FileDB    │   │       User           │   │  ScannerUtils           │
    ├──────────────┤   ├──────────────────────┤   ├─────────────────────────┤
    │ - path       │   │ - firstname          │   │ - scanner: Scanner      │
    ├──────────────┤   │ - username           │   ├─────────────────────────┤
    │ + save()     │   │ ....                 │   │ + inputNumber()         │
    │ + load()     │   ├──────────────────────┤   │ + inputString()         │
    └──────────────┘   │ + mappingToRawData() │   │ + close()               │
                       │ + checkCredential()  │   └─────────────────────────┘
                       │ + searchByName()     │
                       │ + toString()         │
                       └──────────────────────┘
```

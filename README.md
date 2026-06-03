```
                                                  ┌─────────────────────────┐
                    ┌───────────────┐   creates   │  ScannerUtils           │
                    │     Main      │─────────────├─────────────────────────┤
                    └───────────────┘             │ - scanner: Scanner      │
                            │                     ├─────────────────────────┤
                            |                     │ + inputNumber()         │
                            |                     │ + inputDate()           │
                            |                     │ + inputString()         │
                            │ run()               │ + close()               │
                            │                     └─────────────────────────┘
                            │                             |
                            ▼                      inject |
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
               │              │
          uses │         uses │
               ▼              ▼
    ┌──────────────┐   ┌──────────────────────┐
    │    FileDB    │   │       User           │
    ├──────────────┤   ├──────────────────────┤
    │ - path       │   │ - firstname          │
    ├──────────────┤   │ - username           │
    │ + save()     │   │ ....                 │
    │ + load()     │   ├──────────────────────┤
    └──────────────┘   │ + mappingToRawData() │
                       │ + checkCredential()  │
                       │ + searchByName()     │
                       │ + toString()         │
                       └──────────────────────┘
```

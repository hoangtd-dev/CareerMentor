```
┌─────────────────────────────────────────────────────────────────┐
│                             Main                                │
└────┬──────────────────┬──────────────────┬───────────────────── ┘
     │ creates          │ creates          │ creates
     ▼                  ▼                  ▼
┌──────────────┐  ┌───────────────┐  ┌────────────────────┐
│ ScannerUtils │  │ UserRepository│  │    UserHandler     │
├──────────────┤  ├───────────────┤  ├────────────────────┤
│              │  │ - _path       │  │ - _repository:     │
│+inputNumber()│  ├───────────────┤  │   IRepository<User>│
│+inputString()│  │ + save()      │  ├────────────────────┤
│+inputDate()  │  │ + load()      │  │ + register()       │
│+close()      │  └───────┬───────┘  │ + getAllUsers()     │
└──────┬───────┘          │implements│ + getByName()       │
       │inject            ▼          │ + login()           │
       │          ┌───────────────┐  └────────┬───────────┘
       │          │  «interface»  │           │inject
       │          │ IRepository<T>│           │
       │          ├───────────────┤           │
       │          │+ save()       │           │
       │          │+ load()       │           │
       │          └───────────────┘           │
       │                                      │
       └──────────────────┬───────────────────┘
                          │ inject
                          ▼
          ┌──────────────────────────────────────┐
          │         UserManagementSystem         │
          ├──────────────────────────────────────┤
          │ - _scanner   : ScannerUtils          │
          │ - _handler   : UserHandler           │
          ├──────────────────────────────────────┤
          │ + run()                              │
          │ - _showMenu()                        │
          │ - _showUserMenu()                    │
          │ - _handleSelection()                 │
          │ - _handleRegister()                  │
          │ - _handleViewUser()                  │
          │ - _displayAllUsers()                 │
          │ - _searchByName()                    │
          │ - _login()                           │
          └──────────────────────────────────────┘

          ┌──────────────────────────────┐
          │            User              │
          ├──────────────────────────────┤
          │ - _firstname                 │
          │ - _lastname                  │
          │ - _dob                       │
          │ - _username                  │
          │ - _password                  │
          │ - _failedTime                │
          ├──────────────────────────────┤
          │ + mappingToRawData()         │
          │ + checkCredential()          │
          │ + isLooked()                 │
          │ + hasName()                  │
          │ + toString()                 │
          └──────────────────────────────┘
```

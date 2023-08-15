# Uygulama Kullanım Rehberi

1-Uygulama ayağa kaldırılırken CaseApplication run veya debug edilmeli.

2-DB olarak local olarak MySql kullanıldı. Aşağıdaki ayarlar yapılırsa uygulama veritabanı ayarları otomatik yapılır.

- Aşağıda gözüken eski username,password bilgileri; uygulamayı kullanan local makinedeki mysql username,password ile değiştirilebilir.

    spring.datasource.username=

    spring.datasource.password=

- Ayrıca bu ayar update modda bırakılırsa başlangıçta tablolar otomatik oluşur.

    spring.jpa.hibernate.ddl-auto=update


3- Postman'den istek atılırken aşağıdaki bilgiler kullanılabilir.

- find all company için
  
  http://localhost:8080/api/v1/company  -> pathine get isteği atılabilir.

- find company by id için 

  http://localhost:8080/api/v1/company/{} -> pathine path variable olarak id eklenip get isteği atılabilir.

- save company için 

  http://localhost:8080/api/v1/company -> pathine post isteği atılabilir. body kısmına aşağıdaki örnek json formatında eklenebilir.

  {
    "id":1,
    "name":"company1",
    "phone":"0212212121"
  }

- update company için

  http://localhost:8080/api/v1/company -> pathine put isteği atılabilir. body kısmına save'deki örnek body eklenebilir.

- delete company için

  http://localhost:8080/api/v1/company/{} -> pathine path variable olarak id eklenip delete isteği atılabilir.

- find All employee için
  
  http://localhost:8080/api/v1/employee  -> pathine get isteği atılabilir.

- find employee by id için 

  http://localhost:8080/api/v1/employee/{} -> pathine path variable olarak id eklenip get isteği atılabilir.

- save employee için 

  http://localhost:8080/api/v1/employee -> pathine post isteği atılabilir. body kısmına aşağıdaki örnek json formatında eklenebilir.

  {
    "id":1,
    "firstName":"ali",
    "lastName":"demir",
    "gender":"Male",
    "companyId":1
  }

- update employee için

  http://localhost:8080/api/v1/employee -> pathine put isteği atılabilir. body kısmına save'deki örnek body eklenebilir.

- delete employee için

  http://localhost:8080/api/v1/employee/{} -> pathine path variable olarak id eklenip delete isteği atılabilir.

 

House-api

Version 0.3.1:

- 0.1.0: available entrypoints for "FAQ" and "Instruction"

- 0.2.0: implementation of Liquibase integration for DB migrations

- 0.3.0: CRUD operations(<i>save, get, update, delete</i>) now available for "FAQ" and "Instruction"


Application works with local database. It is possible to get access to entrypoints using: 

<i>localhost:8080/house-api/faqs</i> OR <i>instructions</i>

AND 
- /faq(instruction)/{id} - to get by id, delete or update
- /faq(instruction) - to save

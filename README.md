# Adderess Book Application

This is a simple command line Java application that reads a Address Book file, called `AddressBook.txt` and uses its data to answer questions related to the given Address Book.

## Test Questions

1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?

### Answers (Considering the standard AddressBook file)
1. 3 males
2. Wes Jackson
3. Bill is 2862 days older than Paul

## Input Format

1. File named `AddressBook.txt`
2. One entry per line
3. Each entry must follow the order:
```
[FULL NAME], [GENDER], [BIRTH DATE (DD/MM/YYYY)]
```

## Technologies Used
* Java (OpenJDK 21.0.10)

## How to Run?

1. Clone the Repository
```bash
git clone https://github.com/Nicolas-Botelho/AddressBookApp.git
```

2. Compile and Run
```bash
javac addressbook/*.java
java addressbook.Main
```
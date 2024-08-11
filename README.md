
# Splitwise

This is the low level design of Splitwise - Expense sharing application.
An expense sharing application is where you can add your expenses and split it among different people. The app keeps balances between people as in who owes how much to whom.

## Problem statement / requirements

* Add Users to application
  * Takes name as input
  ``` 
  add_user {user-name}
  ````
* List users
  ``` 
  list_users
  ````
* Add Expense to application, multiple formats
  ``` 
  add_expense vada {debtor-id} EQUAL {count-of-debtee} {..debtee-ids..} {amount}
  add_expense vada 1 EQUAL 7 2 3 4 5 6 7 8 100

  add_expense vada {debtor-id} EXACT {count-of-debtee} {..debtee-ids..} {amount} {..amount-divisions..}
  add_expense vada 2 EXACT 1 1 100 100

  add_expense vada {debtor-id} PERCENT {count-of-debtee} {..debtee-ids..} {amount} {..percent-divisions..}
  add_expense dal 1 PERCENT 3 2 3 4 100 50 30 20
  ````
* List all the expenses
  ``` 
  list_expenses
  ````
* List debts of a user
  ``` 
  list_debts {user-id}
  ````
* Stop the application
  ``` 
  exit
  ````

## Example Execution

```
add_user syed1
add_user syed2
add_user syed3
add_user syed4
add_user syed5
add_user syed6
add_user syed7
add_user syed8
list_users
list_debts 1
add_expense vada 1 EQUAL 7 2 3 4 5 6 7 8 100
list_debts 1
add_expense vada 2 EXACT 1 1 100 100
list_debts 2
add_expense dal 1 PERCENT 3 2 3 4 100 50 30 20
list_debts 1
list_expenses
exit


```

## Patterns used

* Strategy Pattern
  * For divisions (EQUAL / EXACT / PERCENT)
  * Input Mode (Command Line / File ...)
  * Output Mode (Command Line / File ...)
* Factory Pattern
  * For division
  * For commands
* Command Pattern
  * For handling commands as input
* Singleton Pattern
  * For handling repositories


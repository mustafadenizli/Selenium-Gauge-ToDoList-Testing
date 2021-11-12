# Specification Heading

Given Empty todo list add new item
----------------------------------
* i write buy some milk to textbox and press enter
* Then i should see buy some milk item in  ToDo list

Given Todo list 'buy some milk' item
------------------------------------
* Given ToDo list with buy some milk item
* i write enjoy the assignment to textbox and press enter
* Then i should see enjoy the assignment item isterted to ToDo list below buy some milk item

Given ToDo list with 'buy some milk' item
-----------------------------------------
* Given ToDo list with buy some milk item
* i click on checkbox next to buy some milk item DONE
* Then i should see buy some milk item marked as DONE

Given todo list with marked item
-------------------------------------
* Given ToDo list with buy some milk item
* Checkbox UnDone Operations
* Then i should see buy some milk item marked as UNDONE

ToDoList new item add and delete operation
------------------------------------------
* Given ToDo list with rest for a while item
* i click on delete button next to rest for a while item
* Then list should be empty


ToDoList new two item add and delete operation
----------------------------------------------
* two item add rest for a while and drink water
* i click on delete button next to 'rest for a while' item
* Then i should see drinkwater in ToDo list

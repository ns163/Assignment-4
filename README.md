## **Assignment Four by Nikhil Sethi (1213414)**

---

### **Task two explanation**


**TextField:** *Text input component that allwos a user to enter a signle line, It does not support multi-line text. 
Text Field support notation of showing prompt text to the user when there is no text already in the textfield. The purpose to use
text field was to allow user to enter one line of text only in the text fields like (First Name, Last Name, Address and city). 
It calls a key event handler when the key is released.*

**TextArea:** *Text area is for multi-line. Multiple line can be added to it and also allows user to edit the text inside the text area.
It calls a key event handler when the key is released and action event handler when the button is pressed. This is used for the country section
where it checks if the country should be added to the text area or not.*

**Check Box:** *The checkbox is used for the Country, it is totally up to the user if he wants to add country to the mailing form or not.
It calls Action event handler and checks if the check box is ticked then it displays the country in the text area with the appropriate line padding.*

**setOnKeyReleased:** *This is a key event, it triggers when a key is released after pressing the key. This event is used because
so it can do live typing while each textField gets the input of a text, it gets the each letter from textField where text is entered
and it is shown on the text area using the "getText" method in javafx. This key event is used for all the textFields in the application 
and functions totally same. This function is called when the event hasnt already consumed during its capturing or bubbling phase.
*

**setOnAction:** *This is an Action event, it triggers when something is clicked, basically a button. This event used for the button and the checkbox.
When the button or checkbox is pressed ot ticked then it triggers it actions like display a message.*

---
### **Task four explanation**


**Error check:** *Checks the existence of the Country if it is appropriate and checks not a wrong country is typed on the country text field and
if wrong country or anything is mispelled then the textbox colour is changed indicating that the country you entered does not match the criteria.
To test if the right country is entered in the text field, I made array list adding 3 or 4 countries and looping through each country to make sure
that the right country is entered. If the right country is entered in the textfield and checkbox is ticked the 
it displays it on the text area and user can toggle it by unchecking and checking the checkbox.*
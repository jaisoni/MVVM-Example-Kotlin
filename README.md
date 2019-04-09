# MVVM-Kotlin
A sample repository for MVVM architecture with dagger2 and databinding in Android written in Kotlin


### Description
This sample contains two fragment one take input from user and second fragment process that data and show result to user.

### Two-way data binding
What is two way binding? In two way binding we can set a value to an attribute and set a listener so that we can get changes in that attribute. I this sample I have used two way binding for getting and setting text from EditText. "=" is used for one way binding i.e. we are only assigning value to the attribute,the @={} notation us used for two way binding.

### MVVM Architecture
Model: These are the data classes. In this repository we have Basket.kt class which collect user inputs View: Activity, Fragments classes 

ViewModel: The ViewModel retrieves the necessary data from the data class, applies the UI logic and then exposes relevant data for the View to consume.

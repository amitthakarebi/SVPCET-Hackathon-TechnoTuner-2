# SVPCET-Hackathon-TechnoTuner-2

Techno Tuner Team 13
Members 
•	Amit R. Thakre (Leader)
•	Kajal G. Lodha
•	Kalyani G. Jat
•	Komal T. Jangid

Problem statement:
In India many problems like Road repairing electricity etc. of people can’t reach to the person in charge responsible for the problem of sometimes the person in charge doesn’t pay heed to the problem. 

Solution:
As above mentioned problem we developed an application “Digital Complaint” which will overcome this hectic situation. 
Digital Complaint will help user to file any social problem just with a few clicks. All he has to do is:
•	Click a picture
•	Write some description about the problem
•	Upload a complaint 

Description:
Structure:
1) Opening screen/Splash Screen 
2) Log in/Signup
3) Home Screen
	New Complaint   
		Name 
		Mobile Number 
		Complaint Department
		Description
		Upload Photo
	All Complaint
		Everyone who enroll complaint
	My Complaint
		Our own complaint 
Emergency
4) Navigation Bar
	About Us
	Share 
	Privacy Policy



If user is already registered then he can directly login from this page, otherwise user have to register 1st with the Name, Email, Password and click the signup button. Then user will be redirect to the page where user has to enter the Mobile Number and after that OTP will be generated for Authentication of a user.

Once user enrolled successfully, after login, user will be enter in Home screen. In “New Complaint” section user can file a new complaint by selecting area of complain, just upload a photograph and little description with location. Now the application will take the Name and contact information automatically to avoid the chances of fake complaints.

In My complaint section, user can view all the complaints filed by him.
In All complaint section, user will be able to see all the complaints which are filed by other users.
In emergency section user can view various emergency number for a quick action such as Fire, Ambulance, and Police etc.


While login to application the admin will click on "Admin Section" button from where he can directly access the Admin module. Here admin is the responsible person for solving the problems. Admin can see all the complaints and update the status of respective complaint. Simultaneously the user will get the acknowledgement of the status.

Future Scope and Conclusion:
In future we can add some more features in this application like live location, separate join application for admin. 

At last we conclude that this application is simple and easy as it doesn’t need any manual procedure to file any complaint and user can get the status of the complaint on the device. 
Apparently Digital Complaint is user friendly as anyone can register a complaint easily


Problem Faced:
It’s difficult to differentiate between Admin and normal user.


Tech-Stack Used:
Android Studio, Java, XML, Database (Firebase).

Video Link:
https://drive.google.com/file/d/1dE7Dkp9wxSTtT_8UKWoIb_bSIo0YImLz/view?usp=drivesdk


To Run This Project Use Following Commands:
1. Login in Android Studio

2. Import Following Libraries (Dependencies) :
	implementation fileTree(dir: "libs", include: ["*.jar"])
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'com.google.android.material:material:1.2.1'
    implementation 'com.google.firebase:firebase-auth:20.0.0'
    implementation 'com.google.firebase:firebase-firestore:22.0.0'
    implementation 'com.google.firebase:firebase-database:19.5.1'
    implementation 'com.google.firebase:firebase-storage:19.2.0'
    testImplementation 'junit:junit:4.13'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    implementation "androidx.browser:browser:1.2.0"
    //glide for image set
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    //swipte to refresh layout
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'

3. Upgrade Latest Gradle Files

4. Install Emulators

5. Connect Firebase To Firebase and Do Setting.

6. Run

Reference :
https://github.com/bumptech/glide ( No need to do anythin just implemented dependency)



**ARC – Adaptive Routine Coach**

ARC is an AI workout coaching prototype designed to adapt a user’s training experience based on their goals, available equipment, daily readiness, and workout feedback.

The project includes a Spring Boot backend, browser based user interface, exercise database integration, readiness evaluation, workout generation, workout tracking, exercise substitutions, skip functionality, workout history, and the ORIN coaching prototype.

**Current Implementation**

The current ARC prototype includes:

- User account creation and signin for local demo accounts
- User profile information
- Training goal selection
- Training experience selection
- Training days per week
- Training workout duration
- Training environment selection
- Equipment selection
- Injury and movement limitation input
- Daily readiness check
- Readiness based workout recommendation
- Goal and equipment based workout generation 
- Active workout tracking
- Set completion tracking
- Exercise skipping
- Exercise substitutions
- Workout history
- Exercise library
- OpenExerciseDB integration
- ORIN coaching prototype
- Logout and saved local user data
- Responsive interface for desktop and mobile devices

**Technology Used**

- Java 21
- IntelliJ
- Spring Boot
- Maven
- Spring Web MVC
- Spring Data JPA
- H2 Database
- HTML
- CSS
- JavaScript
- OpenExerciseDB (rfivesix Richard Georg Schotte) https://github.com/rfivesix/OpenExerciseDB?utm_source
- GitHub
- Railway (paas)

**Requirements**

Before running ARC locally, make sure the computer has:

-Java 21 installed
-To verify Java is installed, open Command Prompt or PowerShell and run:
            
            java -version
-The displayed Java version should be Java 21.
-Internet connection for the initial Maven dependency download
-A web browser such as Google Chrome, Microsoft Edge, or Firefox

**How to Download ARC from GitHub**

-Go to the ARC GitHub repository:

    https://github.com/Cody-Impson/ARC-Adaptive-Routine-Coach
-Select the green Code button.
-Select Download ZIP.
-Extract the downloaded ZIP file.
-Open the extracted ARC project folder.

**How to Run ARC on Windows**

-First open PowerShell or Command Prompt.
-For CMD Run:

    cd Downloads\ARC-Adaptive-Routine-Coach-main\ARC-Adaptive-Routine-Coach-main
-then
  
    .\mvnw.cmd spring-boot:run

-For PowerShell Run:

    cd "$HOME\Downloads\ARC-Adaptive-Routine-Coach-main\ARC-Adaptive-Routine-Coach-main"
-then
  
    .\mvnw.cmd spring-boot:run

-For IntelliJ Open and Run:

    ARC-Adaptive-Routine-Coach-main
-Maven will download any required dependencies during the first run.
-Wait until Spring Boot finishes starting.
-Open a web browser.
-Go to:

    http://localhost:8080
-The ARC splash screen should appear.

**Expected Application Flow**

A user can follow this general ARC workflow:
-Open ARC.
-Select Get Started.
-Create a local demo account or sign in.
-Enter profile information.
-Select training goals.
-Select training environment and available equipment.
-Complete the Daily Readiness Check.
-Review the readiness recommendation.
-Continue to the generated workout.
-Start the workout.
-Complete and record sets.
-Substitute or skip exercises when necessary.
-Use ORIN for coaching recommendations.
-View exercise information in the Exercise Library.
-View completed workout information in History.
-Return to the Profile page or log out.

**Daily Readiness**

ARC evaluates several daily readiness factors:
-leep quality
-Energy
-Soreness
-Stress
-Motivation
-Pain or discomfort
-Optional notes

The readiness system can recommend a normal workout, a modified workout, or a recovery focused workout based on the user’s responses.

The readiness form also validates user input and values must remain within the required ranges, pain descriptions are required when pain is reported, and note length is limited.

**Workout Generation**

ARC generates workouts using saved user information such as:
-Training goal
-Experience level
-Available equipment
-Training environment
-Daily readiness result

Different goals can result in different workout styles, including:
-Strength training
-Muscle building
-Fat loss conditioning
-Endurance conditioning
-General fitness
Available equipment also affects which exercises are selected.

**Active Workout Tracking**

During a workout, users can:
-Record weight
-Record repetitions
-Rate how difficult a set was
-Record how many repetitions they believe they had remaining
-Complete sets
-Advance through exercises
-Skip an exercise
-Substitute an exercise
Completed workout information is saved for the current browser based demo account.

**Exercise Substitutions**

ARC identifies the current exercise and provides replacement exercises based on the type of movement being performed.

For example: a rowing exercise receives pulling related substitutes instead of unrelated pressing exercises.

Selecting a substitute updates the active workout.

**Exercise Library**

ARC includes exercise data from OpenExerciseDB.

The database currently provides hundreds of exercises that can be viewed and searched through the ARC Exercise Library.

Exercise information may include categories such as:
-Exercise name
-Difficulty
-Movement type
-Equipment
-Muscles
-Mechanics
-Laterality
-Tracking information

**ORIN**

ORIN is the coaching component of ARC.

In the current prototype, ORIN uses programmed decision logic to respond to common workout situations such as:
-A weight feeling too heavy
-Equipment being unavailable
-Pain or discomfort
-Exercise adjustment situations

ORIN is currently a rule based prototype and is not yet connected to a live language model.

Future development could connect ORIN to a full conversational AI system.

**Workout History**

ARC records completed workout information locally in the browser.

History can display information such as:
-Completed exercises
-Completed sets
-Weight
-Repetitions
-Effort
-Repetitions remaining
-Recent readiness results
-Skipped exercises
Users can select a workout in History to view additional workout details.

**Local Demo Accounts**

The current prototype uses browser local storage for account and workout information.

Each account created in the same browser can maintain separate ARC data.

Note** This is a prototype account system and is not intended to represent production authentication or cloud account security.

User information does not automatically synchronize between different computers or browsers.

**Database**

ARC uses an H2 database as part of the Spring Boot application.

The current development database is temporary and may reset when the application restarts.

Future development would replace this with a persistent production database.

**Live Deployment**

ARC is also deployed online using Railway.

The live prototype can be accessed at:

    https://orin-arc.com

The Railway deployment may enter a sleeping state during periods of inactivity. Visiting the site wakes the deployed application.

The locally reproduced version of ARC is accessed at:

    http://localhost:8080

The live Railway deployment is accessed at:

    https://orin-arc.com

**Project Limitations**

ARC is currently a development prototype and not a finished commercial fitness application.

Current limitations include:

-Browser local account storage
-No cloud synchronization
-No production authentication system
-Temporary H2 database
-Rule based ORIN coaching
-Limited exercise instructional media
-No dedicated native mobile application
-Readiness recommendations are more advanced than the current automatic workout intensity adjustment system

**Future Development**

Future versions of ARC could include:
-Secure cloud based user authentication
-Persistent cloud database
-Cross device account synchronization
-Full AI powered ORIN coaching
-More advanced readiness-based workout modification
-Exercise instructional videos
-Expanded exercise instructions
-Voice interaction
-Mobile application
-Nutrition tracking
-Longterm progress analysis
-More advanced workout personalization

**Project Repository**

GitHub:

    https://github.com/Cody-Impson/ARC-Adaptive-Routine-Coach

Live ARC Prototype:

    https://orin-arc.com

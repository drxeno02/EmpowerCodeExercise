# EMPOWER INTERVIEW PROJECT - ANDROID
Instructions and details for how this project was developed.

## Table of Contents

* [Build tools & versions used](#build-tools-versions-used)
* [Steps to run the app](#steps-to-run-app)
* [What areas of the app did you focus on?](#areas-of-focus)
* [How long did you spend on this project?](#time-spent-on-project)
* [Did you make any trade-offs for this project? What would you have done differently with more time?](#trade-offs-done-differently)
* [Is there any other information you’d like us to know?](#additional-information)
* [CHANGELOG](#changelog)

<a name="build-tools-versions-used"></a>
## Build tools & versions used

Per instructions, no third-party dependencies were used. The gradle wasn't modified or touched
from the default project setup.

CompileSDK = 34
MinSDK = 24
TargetSDK = 34

[table of contents](#table-of-contents)

<a name="steps-to-run-app"></a>
## Steps to run the app

No special steps to run the app. It is a straight forward build.

<a name="areas-of-focus"></a>
## What areas of the app did you focus on?

It is not too common to build apps without XML or Compose or added dependencies. My focus was
keeping things simple and well-constructed. I setup a project structure based on Android components.
I added code documentation, maintained a level of abstraction, and tried to reduce redundancy.

[table of contents](#table-of-contents)

<a name="time-spent-on-project"></a>
## How long did you spend on this project?

Below is the timesheet for the project:

Format: (yyyy-mm-dd)
1. 2024-04-18 | Project Setup - 10 mins
2. 2024-04-18 | MainActivity - 20 mins
3. 2024-04-18 | Adapter/Models - 1 hr
4. 2024-04-18 | README - 15 mins

[table of contents](#table-of-contents)

<a name="trade-offs-done-differently"></a>
## Did you make any trade-offs for this project? What would you have done differently with more time?

The biggest trade-off for this project was that I created a simple UI. Because the UI was so simple,
I did not go into ConstraintLayouts or anything else complicated. I did not include rounded corners,
or try to add animations. The main thing for me was making sure I completed all of the specific
instructions:

1. Each row should display the firstName, lastName, beneType and designation. A "P" designationCode
translates to "Primary" designation and "C" translates to "Contingent" designation.
2. Selecting a beneficiary should show additional information about them - SSN, date of birth, 
phone number and address. Date of birth is provided in the format "MM/dd/yyyy".

[table of contents](#table-of-contents)

<a name="additional-information"></a>
## Is there any other information you’d like us to know?

Thank you for this opportunity to interview with you. I am excited and look forward to hearing 
from you.

[table of contents](#table-of-contents)

<a name="changelog"></a>
## CHANGELOG

Format: (yyyy-mm-dd)
1. 2024-04-18: README created (1.0.0)\

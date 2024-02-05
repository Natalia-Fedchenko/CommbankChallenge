# CommbankChallenge

This is an example project for Commbank coding challenge
This basic framework is using Maven as a build tool, 
Java11 with Rest Assured and BDD approach (Allure)
using Allure Reports for better observability
Using Gitlab for CI/CD

To run locally
Clone the project , then run locally:
mvn clean test
mvn allure:serve

To run from CI/CD (GITLAB)
Visit GitLab:
Open this project on the GitLab website.

Navigate to CI/CD Pipelines:
Go to your project and navigate to "CI/CD > Pipelines" in the GitLab UI. You'll see the pipeline(s) triggered by your recent commit.

Monitor Pipeline Execution:
GitLab will automatically start executing the pipeline stages defined in your .gitlab-ci.yml file. You can monitor the progress of the pipeline, view logs, and check for any issues.

View Results:
Once the pipeline is complete, you can check the results, including whether the tests passed or failed. If there are any issues, you can inspect the logs to identify the problem.

Access Artifacts:
If your pipeline generates artifacts (such as reports or binaries), you can access them in the "Artifacts" section of the pipeline.


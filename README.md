#AWS SkySail Sample Application
This package contains a simple Sales System application that creates and lists the orders created by the customers.

## Before you begin
### Prerequisites
* Install Maven using instructions [here](http://maven.apache.org/)
* Install Java using instructions [here](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/setup-install.html#java-dg-java-env)

### Create Profiling Group
* Go to the SkySail console https://console.aws.amazon.com/skysail/profiler/search
* Click “Create Profiling Group”
* In the text box, provide a name for your profiling group
* Click “Create a profiling group”

## Create an EC2 instance to run this application on AWS
* [Create](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/launching-instance.html) a EC2 instance 
* [Connect](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AccessingInstances.html) to your instance 
* Copy the ZIP file to the instance
* Unzip

## Integrate the application with the SkySail Profiler
* Navigate to the unzipped folder `cd AWSSkySailSample`
* Change the line number 18 (shown below) on file `src/main/java/com/company/sampleApplication/SalesSystem.java` to submit profiling data the profiling group just created.
    ```
    Profiler systemProfiler = new Profiler("<insert the profiling group name here>", DefaultAWSCredentialsProviderChain.getInstance());
    ```
* Build the package ``mvn package``
* Run the application
  * If using EC2 instance profile role
    ```
    mvn exec:java -Dexec.mainClass=com.company.sample.application.SalesSystem
    ```
  * If not using EC2 instance profile role, pass the credentials as the java system properties
    ```
    mvn exec:java -Dexec.mainClass=com.company.sample.application.SalesSystem -Daws.accessKeyId=<AccessKeyId> -Daws.secretKey=<SecretKey>
    ```
* A few seconds after the program is started you should see the following message on the standard output:
    ```
    INFO: Profiling scheduled, sampling rate is PT1S
    ```
* After 5 to 10 minutes you should see the following message denoting a successful report of profiling data.
    ```
    INFO: Successfully reported profile
    ```
* Go to the [SkySail Console](https://console.aws.amazon.com/skysail/profiler/search?region=us-east-1) and click your profiling group in order to see the profiling data. 

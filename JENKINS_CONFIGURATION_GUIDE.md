# Jenkins Configuration Guide

## 🎯 How to Run All Test Runners in Jenkins

### **Current Configuration**

Your `testng.xml` now includes all test runners:
- TestRunner (Login tests)
- RegisterRunner
- ProductPageRunner
- SearchPageRunner
- ExcelLoginRunner
- BillingRunner
- OrderConfirmationRunner
- EndToEndRunner

---

## 📋 **Option 1: Run All Runners (Default)**

### In Jenkins:
```groovy
bat 'mvn clean test'
```

This will run `testng.xml` which includes all 8 runners.

**Execution Time:** ~10-15 minutes (sequential)

---

## 📋 **Option 2: Run Specific Test Suite**

### Available Suites:

1. **testng.xml** - All runners (default)
2. **master_suite.xml** - All runners organized by category
3. **parallel_suit.xml** - Parallel execution
4. **Cross_Browser.xml** - Cross-browser testing
5. **smoke_suite.xml** - Smoke tests only
6. **regression_suite.xml** - Regression tests

### In Jenkinsfile:
```groovy
// Run master suite
bat 'mvn clean test -DsuiteXmlFile=master_suite.xml'

// Run parallel suite
bat 'mvn clean test -DsuiteXmlFile=parallel_suit.xml'

// Run cross-browser
bat 'mvn clean test -DsuiteXmlFile=Cross_Browser.xml'
```

---

## 📋 **Option 3: Run Specific Runner**

### In Jenkinsfile:
```groovy
// Run only BillingRunner
bat 'mvn test -Dtest=BillingRunner'

// Run multiple specific runners
bat 'mvn test -Dtest=BillingRunner,RegisterRunner,ProductPageRunner'
```

---

## 📋 **Option 4: Parameterized Jenkins Job**

### Add Parameters to Jenkins Job:

1. Go to Jenkins Job → Configure
2. Check "This project is parameterized"
3. Add Choice Parameter:
   - Name: `TEST_SUITE`
   - Choices:
     ```
     testng.xml
     master_suite.xml
     parallel_suit.xml
     Cross_Browser.xml
     smoke_suite.xml
     regression_suite.xml
     ```

### Update Jenkinsfile:
```groovy
stage('Build & Test') {
    steps {
        bat "mvn clean test -DsuiteXmlFile=${params.TEST_SUITE}"
    }
}
```

Now users can select which suite to run!

---

## 🔧 **Your Current Setup**

### testng.xml (Default)
```xml
<suite name="BDD Cucumber Complete Test Suite">
  <test name="All Cucumber Tests">
    <classes>
      <class name="Runner.TestRunner"/>
      <class name="Runner.RegisterRunner"/>
      <class name="Runner.ProductPageRunner"/>
      <class name="Runner.SearchPageRunner"/>
      <class name="Runner.ExcelLoginRunner"/>
      <class name="Runner.BillingRunner"/>
      <class name="Runner.OrderConfirmationRunner"/>
      <class name="Runner.EndToEndRunner"/>
    </classes>
  </test>
</suite>
```

### master_suite.xml (Organized)
```xml
<suite name="Master Test Suite - All Runners">
  <test name="Login Tests">
    <classes>
      <class name="Runner.TestRunner"/>
      <class name="Runner.ExcelLoginRunner"/>
    </classes>
  </test>
  
  <test name="Registration Tests">
    <classes>
      <class name="Runner.RegisterRunner"/>
    </classes>
  </test>
  
  <test name="Product Tests">
    <classes>
      <class name="Runner.ProductPageRunner"/>
      <class name="Runner.SearchPageRunner"/>
    </classes>
  </test>
  
  <test name="Checkout Tests">
    <classes>
      <class name="Runner.BillingRunner"/>
      <class name="Runner.OrderConfirmationRunner"/>
    </classes>
  </test>
  
  <test name="End to End Tests">
    <classes>
      <class name="Runner.EndToEndRunner"/>
    </classes>
  </test>
</suite>
```

---

## ✅ **What's Fixed**

1. ✅ **testng.xml** - Now includes all 8 runners
2. ✅ **master_suite.xml** - Created organized suite
3. ✅ **pom.xml** - Configured to use testng.xml
4. ✅ **Jenkinsfile** - Updated with multiple options
5. ✅ **JUnit reports** - Fixed path with allowEmptyResults

---

## 🚀 **Recommended Approach**

### For Jenkins CI/CD:

**Option A: Run All Tests (Comprehensive)**
```groovy
bat 'mvn clean test'
```
- Runs all 8 runners
- Takes 10-15 minutes
- Best for nightly builds

**Option B: Run Parallel (Faster)**
```groovy
bat 'mvn clean test -DsuiteXmlFile=parallel_suit.xml'
```
- Runs tests in parallel
- Takes 5-7 minutes
- Best for quick feedback

**Option C: Run Smoke Tests (Fastest)**
```groovy
bat 'mvn clean test -DsuiteXmlFile=smoke_suite.xml'
```
- Runs critical tests only
- Takes 2-3 minutes
- Best for every commit

---

## 📊 **Execution Time Estimates**

| Suite | Runners | Time | Use Case |
|-------|---------|------|----------|
| testng.xml | 8 | 10-15 min | Full regression |
| master_suite.xml | 8 | 10-15 min | Organized full run |
| parallel_suit.xml | All features | 5-7 min | Fast feedback |
| Cross_Browser.xml | 3 browsers | 15-20 min | Browser compatibility |
| smoke_suite.xml | Critical | 2-3 min | Quick validation |

---

## 🎯 **Your Current Jenkinsfile**

```groovy
stage('Build & Test') {
    steps {
        // Currently runs testng.xml with all 8 runners
        bat 'mvn clean test'
    }
}
```

**This will now run ALL your test runners!** ✅

---

## 💡 **Pro Tips**

1. **For Daily Builds:** Use `testng.xml` (all tests)
2. **For Every Commit:** Use `smoke_suite.xml` (fast)
3. **For Release:** Use `Cross_Browser.xml` (comprehensive)
4. **For Speed:** Use `parallel_suit.xml` (parallel execution)

---

## ✅ **Next Steps**

1. Commit and push changes to GitHub
2. Run Jenkins job
3. All 8 runners will execute
4. Check Allure reports for results

**Your Jenkins is now configured to run all test runners!** 🎉

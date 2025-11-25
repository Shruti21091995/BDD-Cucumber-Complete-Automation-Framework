# 📧 Quick Reference - Dynamic Email Function

## 🎯 The Simple Function (Copy-Paste Ready)

```java
/**
 * Generates a unique email by adding current time to it
 * 
 * HOW IT WORKS:
 * Input:  smita.patil@gmail.com
 * Output: smita.patil_1732531200@gmail.com
 * 
 * Every time you run the test, the number changes, so email is always unique!
 */
private String generateDynamicEmail(String originalEmail) {
    
    // Step 1: Get current time in milliseconds (this number is always different)
    long currentTime = System.currentTimeMillis();
    
    // Step 2: Split email into two parts: before @ and after @
    // Example: "smita.patil@gmail.com" becomes ["smita.patil", "gmail.com"]
    String beforeAt = originalEmail.split("@")[0];  // smita.patil
    String afterAt = originalEmail.split("@")[1];   // gmail.com
    
    // Step 3: Create new email by adding time between name and @
    // Result: smita.patil_1732531200@gmail.com
    String uniqueEmail = beforeAt + "_" + currentTime + "@" + afterAt;
    
    // Step 4: Return the unique email
    return uniqueEmail;
}
```

---

## 📖 How to Use It

```java
@When("the user provides valid details:")
public void the_user_provides_valid_details(io.cucumber.datatable.DataTable dataTable) {
    
    String email = data.get(0).get("Email");
    
    // ✅ Call the function to get unique email
    String dynamicEmail = generateDynamicEmail(email);
    
    // ✅ Log it (optional but helpful)
    logger.info("Using dynamic email for registration: {}", dynamicEmail);
    
    // ✅ Use dynamicEmail instead of email
    register.RegistrationDetails(firstName, lastName, dynamicEmail, password, confirmPassword, "Female");
}
```

---

## 🔍 What Each Line Does

| Line | What It Does | Example |
|------|-------------|---------|
| `long currentTime = System.currentTimeMillis();` | Gets current time as a number | `1732531200000` |
| `String beforeAt = originalEmail.split("@")[0];` | Gets part before @ | `"smita.patil"` |
| `String afterAt = originalEmail.split("@")[1];` | Gets part after @ | `"gmail.com"` |
| `String uniqueEmail = beforeAt + "_" + currentTime + "@" + afterAt;` | Combines all parts | `"smita.patil_1732531200000@gmail.com"` |
| `return uniqueEmail;` | Returns the unique email | Returns to caller |

---

## 🎬 Real Example

### Input:
```
smita.patil@gmail.com
```

### Processing:
```
Step 1: currentTime = 1732531200000
Step 2: beforeAt = "smita.patil"
        afterAt = "gmail.com"
Step 3: uniqueEmail = "smita.patil" + "_" + "1732531200000" + "@" + "gmail.com"
Step 4: return "smita.patil_1732531200000@gmail.com"
```

### Output:
```
smita.patil_1732531200000@gmail.com
```

---

## ✅ Benefits

| Before | After |
|--------|-------|
| ❌ Same email every run | ✅ Unique email every run |
| ❌ Test fails on 2nd run | ✅ Test passes every time |
| ❌ Manual cleanup needed | ✅ No cleanup needed |
| ❌ Can't run in parallel | ✅ Parallel execution safe |

---

## 🎤 Interview Answer

**Q: How do you handle duplicate test data in your framework?**

**A:** "I implemented dynamic email generation using `System.currentTimeMillis()`. The function takes the original email, splits it at the @ symbol, adds the current timestamp in the middle, and returns a unique email. For example, `test@gmail.com` becomes `test_1732531200@gmail.com`. This ensures every test run uses unique data, making the framework safe for parallel execution and CI/CD pipelines."

---

## 📝 One-Line Summary

**Add current time to email = Always unique!**

```
test@gmail.com → test_1732531200@gmail.com
```

**That's it!** 🎉

# 📧 Dynamic Email Generation - Simple Explanation

## 🎯 What Problem Does It Solve?

**Problem:** When you run the same registration test twice, it fails because the email already exists.

```
First Run:  Register with smita.patil@gmail.com ✅ SUCCESS
Second Run: Register with smita.patil@gmail.com ❌ FAIL (email already exists!)
```

**Solution:** Make the email unique every time by adding current time to it!

```
First Run:  Register with smita.patil_1732531200@gmail.com ✅ SUCCESS
Second Run: Register with smita.patil_1732531205@gmail.com ✅ SUCCESS
Third Run:  Register with smita.patil_1732531210@gmail.com ✅ SUCCESS
```

---

## 📝 The Simple Function

```java
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

## 🔍 Step-by-Step Breakdown

### **Step 1: Get Current Time**
```java
long currentTime = System.currentTimeMillis();
```

**What it does:** Gets the current time in milliseconds since January 1, 1970.

**Example values:**
- Monday 10:00 AM: `1732531200000`
- Monday 10:01 AM: `1732531260000`
- Monday 10:02 AM: `1732531320000`

**Why?** This number is ALWAYS different, so your email will ALWAYS be unique!

---

### **Step 2: Split Email into Parts**
```java
String beforeAt = originalEmail.split("@")[0];  // Part before @
String afterAt = originalEmail.split("@")[1];   // Part after @
```

**Example:**
```
Input: "smita.patil@gmail.com"

After split:
beforeAt = "smita.patil"
afterAt  = "gmail.com"
```

**Visual:**
```
smita.patil @ gmail.com
    ↓           ↓
beforeAt     afterAt
```

---

### **Step 3: Create Unique Email**
```java
String uniqueEmail = beforeAt + "_" + currentTime + "@" + afterAt;
```

**How it combines:**
```
beforeAt     +  "_"  +  currentTime    +  "@"  +  afterAt
   ↓            ↓          ↓               ↓        ↓
"smita.patil" + "_" + "1732531200" + "@" + "gmail.com"
                            ↓
Result: "smita.patil_1732531200@gmail.com"
```

---

### **Step 4: Return the Email**
```java
return uniqueEmail;
```

**Returns:** `smita.patil_1732531200@gmail.com`

---

## 🎬 Real Example - How It Works in Your Test

### **In Feature File:**
```gherkin
When the user provides valid details:
  | FirstName | LastName | Email                     | Password  | ConfirmPassword |
  | smita     | patil    | smita.patil.new@gmail.com | Abc@12345 | Abc@12345       |
```

### **In Java Code:**
```java
@When("the user provides valid details:")
public void the_user_provides_valid_details(io.cucumber.datatable.DataTable dataTable) {
    
    // Get email from feature file
    String email = data.get(0).get("Email");  
    // email = "smita.patil.new@gmail.com"
    
    // Generate unique email
    String dynamicEmail = generateDynamicEmail(email);
    // dynamicEmail = "smita.patil.new_1732531200@gmail.com"
    
    // Log it
    logger.info("Using dynamic email for registration: {}", dynamicEmail);
    
    // Use the unique email for registration
    register.RegistrationDetails(firstName, lastName, dynamicEmail, password, confirmPassword, "Female");
}
```

---

## 📊 Visual Flow

```
┌─────────────────────────────────────────────────────────────┐
│ Feature File                                                │
│ Email: smita.patil.new@gmail.com                           │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│ Java Code - generateDynamicEmail()                         │
│                                                             │
│ 1. Get time: 1732531200                                    │
│ 2. Split: "smita.patil.new" + "@" + "gmail.com"           │
│ 3. Combine: "smita.patil.new_1732531200@gmail.com"        │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│ Website Registration                                        │
│ Registers: smita.patil.new_1732531200@gmail.com           │
│ Status: ✅ SUCCESS (unique email!)                         │
└─────────────────────────────────────────────────────────────┘
```

---

## 🧪 Test It Yourself

Run this test 3 times and see different emails:

**Run 1 (Monday 10:00 AM):**
```
Input:  smita.patil@gmail.com
Output: smita.patil_1732531200000@gmail.com
```

**Run 2 (Monday 10:05 AM):**
```
Input:  smita.patil@gmail.com
Output: smita.patil_1732531500000@gmail.com
```

**Run 3 (Monday 10:10 AM):**
```
Input:  smita.patil@gmail.com
Output: smita.patil_1732531800000@gmail.com
```

All different! ✅

---

## 💡 Why This Works

1. **System.currentTimeMillis()** returns the number of milliseconds since January 1, 1970
2. This number increases every millisecond
3. So every time you run the test, you get a different number
4. Different number = Different email = No duplicates!

---

## 🎯 Benefits

✅ **No duplicate email errors**  
✅ **Can run tests multiple times**  
✅ **Works in parallel execution**  
✅ **No manual cleanup needed**  
✅ **Professional approach**  

---

## 📝 Summary in One Line

**"Add current time to email, so it's always unique!"**

```
smita.patil@gmail.com  →  smita.patil_1732531200@gmail.com
                              (always different!)
```

---

**That's it! Simple and effective!** 🎉

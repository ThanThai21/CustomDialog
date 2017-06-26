# CustomDialog
To simplify creating dialog with any layout

![alt_text](https://github.com/ThanThai21/CustomDialog/blob/master/screenshot.PNG)

<br/>

# Add library to your project
## Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
<br/>
## Step 2. Add the dependency

```
dependencies {
	        compile 'com.github.ThanThai21:CustomDialog:1.0.0'
	}
```

# Usage
# Step 1. Create your layout dialog in app/res/layout
# Step 2. Use it in your activity
```
CustomAlertDialog customAlertDialog;
customAlertDialog = new CustomAlertDialog.Builder(MainActivity.this, R.layout.dialog)
                .titleId(R.id.title_tv, "Title")
                .negativeButtonId(R.id.negative, "Cancel")
                .negativeListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customAlertDialog.cancel();
                    }
                })
                .positiveListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customAlertDialog.cancel();
                    }
                })
                .positiveButtonId(R.id.positive, "OK")
                .build();
```

You can show or cancel this dialog using show()/cancel()
```
customAlertDialog.show();
```


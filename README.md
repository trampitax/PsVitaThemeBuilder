# PsVitaThemeBuilder
### Creating your Ps Vita Themes has never been so easy
<a name="Description"><a/>
## Description
PsVitaThemeBuilder is a java based application to create and personalize your themes in an easy and fast way. It's available for Microsoft Windows, Linux and Mac OS.

<a name="Usage"><a/>
## Usage
To execute the jar file you can write the following command in your terminal, or you can also save it into a .bat or .sh file
```
java -jar PsVitaThemeBuilder.jar
```
  
To create a theme, you will only need to provide this information:
- Theme Title
- Author Name
- LockScreen Image Path
- First Page Image Path

All other information is totally optional. Colors are predefined but you can change them though.

<a name="Installing"><a/>
## Installing a Theme
  [Custom Themes Manager](http://redsquirrel87.altervista.org/doku.php/custom-themes-manager) is an application for your PSVita. It will help you downloading, installing, unistalling, etc. your custom themes. All of their themes are uploaded to a [free online repository](https://psv.altervista.org), I encourage you to upload your themes there.
  
  For moving your theme from your computer to your PsVita use [PSVita DB Theme Installer](http://redsquirrel87.altervista.org/doku.php/psvita-db-theme-installer). It's a free java application available for Windows, Linux and Mac OS Systems. Of course there are other ways to install your theme manually, but using this tool is quite easy.
  
<a name="External"><a/>
## External Tool
As you probably know, PsVita Themes can include music and I of course took that into account.
  To take advantage of this option, you have to use Microsoft Windows since PsVitaThemeBuilder uses [`at9tool.exe`](https://amicitiamods.jcink.net/index.php?s=c0de8c821d4862b3d66975cc0f3a558f&showtopic=29&st=0&#entry56) to convert `.WAV` files to `.AT9` format.
  In a future I'll try to make possible to use this feature in Linux. Anyway, if you already have the `BGM.at9` file you can just drag and drop it to your theme folder.

  ``` 
 at9tool.exe MUST be in the same folder as the .jar file 
 ```

<a name="Download"><a/>
## Download
https://github.com/trampitax/PsVitaThemeBuilder/releases/

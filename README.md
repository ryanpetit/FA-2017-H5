# FA-2017-H5
Usage of RecyclerViews, Adapters and ViewHolders with a sprinkling of Glide and Gson


Errata:

*****************************************************
Gradle
In the Module:app build.gradle, add the following annotation under the "compile 'org.parceler:parceler-api:1.1.9'" dependency:

annotationProcessor 'org.parceler:parceler:1.1.9'

*****************************************************


Recipe

Decorate the class with the @Parcel annotation.

*****************************************************

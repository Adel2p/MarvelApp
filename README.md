# Marvel Compose App

App created in compose that displays Marvel heroes using the [marvel api](https://developer.marvel.com/docs)

This app uses MVVM but trying to follow the [Recommended app architecture](https://developer.android.com/jetpack/guide#recommended-app-arch)
at the same time.

## Getting Started

The project files can be found at https://github.com/jeprubio/marvel-compose/

Easiest and simple way to download code from Github is to download the whole code in a zip file by clicking the "Code" / "Download Zip" button on the right hand side of the page.

You can then save the zip file into a convenient location on your computer and start working on it.

Another way to get the code is using git:

git clone git@github.com:jeprubio/marvel-compose.git

## Prerequisites

Android studio should be installed in order to run the app.

Follow the instructions at https://developer.android.com/studio/install depending on which SO your computer is running.


## Libraries Used

- [Timber](https://github.com/JakeWharton/timber) - Library to perform logging.

- [Gson](https://github.com/google/gson) - To parse from and to json (configured retrofit to use it).

- [Retrofit](https://github.com/square/retrofit) - To perform API calls and parse the response.

- [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - For dependency injection.

- [Coil](https://github.com/coil-kt/coil) - Loading and caching images.

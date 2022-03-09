## Core Module

[A pure Java/Kotlin module](https://github.com/kasem-sm/SlimeKT/tree/dev/core) that consists of core business models, classes and utilities for all other modules in the project. It doesn't depend on any other modules.

## Feature Modules Structure
Every feature module consists of the following sub-modules:

- **datasource:** Contains interface for cache and network which can be injected to `interactors` module. This can also make testing easier. The naming convention of the classes in this module are `XFeatureApiService`, `XFeatureDatabaseService`

- **datasource-impl:** Contains concrete implementation of the interface from the datasource module. The naming convention of the classes are `XFeatureApiServiceImpl`, `XFeatureDatabaseServiceImpl`

- **domain/model:** Contains the UI Model class of the feature which can be provided to `feature-common-ui` modules or the module where the screen using the feature resides.

- **domain/interactors:** Contains use-cases/business logic of the feature. It takes datasource as a dependency. Fetching and caching related works are done here. 

- worker: Performs task(s) using WorkManager related to the current feature. 

- feature-common-ui: Contains feature common Ui elements. For instance, `Article CardView` which is displayed in two different screens are added into `feature-common-ui` modules.


## Feature Article
Article feature module consists of two extra modules including all the other modules that a feature module usually contains. The four extra modules are:

- **markdown:** Contains all the necessary classes which helps in rendering text markdown in Article Detail Screen. It depends on a third party library called `commonmark`.
- **widget:** It contains all the necessary classes that help in creating a Daily Read widget using Jetpack Glance API.
- **worker:** This module manages the Daily Read feature. It consists of `DailyReadManager` which fetches articles and shows them as Daily Read via notification and widget.
- **article-common-ui:** Contains common UI components related to Article such as ArticleCard which is used in every screen where an article is displayed.
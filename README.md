# 🍽️ RecipesApp

## 📖 Introducción

RecipesApp es una aplicación Android desarrollada como prueba técnica. Permite mostrar un listado de recetas obtenidas desde una API REST, almacenarlas en una base de datos local y consultarlas offline. Al seleccionar una receta, se muestra un diálogo con su nombre e instrucciones detalladas.

El proyecto sigue el patrón **MVVM** y utiliza tecnologías modernas recomendadas para el desarrollo Android.

---

## ✨ Funcionalidades

- Consumo de API REST pública [DummyJSON Recipes API](https://dummyjson.com/recipes?limit=30)
- Almacenamiento local de las recetas con Room
- Visualización de la lista de recetas en Compose
- Diálogo emergente al pulsar una receta mostrando su nombre e instrucciones
- Gestión de estados (cargando, éxito, error)
- Pruebas unitarias para la lógica principal
- Uso de corrutinas para asegurar una UI fluida y no bloqueante

---

## ⚙️ Tecnologías utilizadas

- **Lenguaje:** Kotlin
- **UI:** Jetpack Compose
- **Arquitectura:** MVVM
- **Red:** Retrofit + Gson
- **Base de datos:** Room
- **Gestión de concurrencia:** Kotlin Coroutines
- **Gestión de estado:** StateFlow
- **Tests:** JUnit4 + Mockito

---

## 🏗️ Estructura del proyecto

```
RecipesChallenge
│── app
│   ├── data
│   │   ├── local
│   │   │   ├── dao
│   │   │   ├── database
│   │   │   ├── entities
│   │   ├── remote
│   │   │   ├── dto
│   │   ├── repository
│   ├── domain
│   │   ├── mapper
│   │   ├── model
│   │   ├── repository
│   │   ├── usecase
│   ├── presentation
│   │   ├── ui
│   │   ├── viewmodel
│   ├── di
│   ├── utils
```

### Requisitos previos

- Android Studio **Koala** | 2024.1.1 Patch 1 or later (this is my version)

### Instalación

1. **Copia la url del repositorio**

```sh
git clone https://github.com/RVenturaSuarez/RecipesChallenge.git
```

2. **Abre el proyecto en Android Studio**

   - Abre Android Studio
   - Haz click en el botón `Get from VCS`
   - Pega la url del proyecto `https://github.com/RVenturaSuarez/RecipesChallenge.git`
   - Selecciona la carpeta donde quieres guardarlo
   - Haz click en el botón clone

3. **Ejecuta el proyecto**

   - Pulsa en Sync Gradle files
   - Haz click en el botón `Run` ▶️ in Android Studio

## ✅ Ejecución de pruebas

Para lanzar los Unit Test, ejecuta en el terminal:

```sh
./gradlew testDebugUnitTest
```

## 🔧 CI GitHub Actions

Este proyecto incluye un flujo de trabajo de GitHub Actions para pruebas automatizadas. Ejecuta las pruebas en cada push o pull request a las ramas `master` y `develop`


## 📸 Screenshots

![Demo](assets/recipesScreen.gif)

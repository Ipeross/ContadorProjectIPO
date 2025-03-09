# Contador Project IPO 🎯

## Descripción

Este es un proyecto de una aplicación de contador desarrollada en Android utilizando Jetpack Compose. 📱

## Tecnologías Utilizadas

- **Navigation Compose**: Para manejar la navegación entre pantallas.

- **Jetpack Compose**: Para la creación de la interfaz de usuario.
- **ViewModel**: Para gestionar el estado del contador de manera persistente.
- **MutableState**: Para manejar cambios de estado dentro del ViewModel.
- **Data Class**: Para la navegación y paso de datos entre pantallas.

## Funcionalidad ⚡

- Navegación entre pantallas utilizando Navigation Compose y Data Class para pasar datos.

- Incrementar y decrementar el contador.
- Mantener el valor del contador entre pantallas gracias al uso de ViewModel y MutableState.
- Navegación entre pantallas utilizando una Data Class para pasar datos.

# Rubrica 🖊

---

## **1. Definición de Componentes y Gestión de Estados (1.5 puntos)**  

- **(0.75 pts)** Creación de un ejemplo claro y funcional para definir componentes.
**--> Los componentes ClickCounter y DisplayCounter están bien definidos y cumplen su función.**
- **(0.75 pts)** Implementación correcta de la gestión de estados en Jetpack Compose.
**--> Se usa mutableStateOf en el ViewModel para gestionar el contador correctamente.**

---

## **2. Navegación entre Pantallas (1.5 puntos)**  

- **(0.75 pts)** Implementación de un sistema de navegación eficiente y bien estructurado.
**--> La navegación entre pantallas se maneja con NavController y NavHost.**
- **(0.75 pts)** Uso adecuado de mecanismos de navegación en Jetpack Compose.
**--> Se navega entre pantallas pasando el contador como argumento con navController.navigate().**

---

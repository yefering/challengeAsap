@frontend @testRegresion
Feature: Inicio de sesion en DemoBlaze

  Background: el cliente ingresa a DemoBlaze
    Given el usuario se encuentra en al home

  @logingBlazeOk
  Scenario: Usuario se loguea de forma correcta
    When el usuario hace clic en el boton "LogIn"
    And el usuario ingresa "userasap" en el campo "Username"
    And el usuario ingresa "userasap" en el campo "Password"
    And el usuario hace clic en el boton "Log In"
    Then el usuario visualiza "Welcome userasap"

  @logingBlazeFail
  Scenario: Usuario no se loguea de forma correcta
    When el usuario hace clic en el boton "LogIn"
    And el usuario ingresa "userasap" en el campo "Username"
    And el usuario ingresa "userasappp" en el campo "Password"
    And el usuario hace clic en el boton "Log In"
    Then el usuario visualiza el Popup con el mensaje "Wrong password."


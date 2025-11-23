**Week 4 Practical Exercises: Object-Oriented Design and MVC**
This repository contains solutions to three core Java exercises from Week 4, focusing on object-oriented programming principles, event-driven design, and layered architecture patterns.

**Overview**
**1. Contact Book: Equality & Copying**

Explores object identity vs logical equality with a Contact model. Emphasizes deep copying and defensive copying to maintain immutability and encapsulation. Key features include:

Immutable Address value object

Logical equality of Contact objects based on email

Deep copy constructor to prevent shared mutable state

Defensive copies returned from getters

Demonstration contrasting shallow and deep copies

**2. Sensor Hub: Events & Observer**

Implements an event-driven SensorHub class that notifies registered listeners of sensor readings. Illustrates:

Listener interface with callback methods for readings and threshold crossing

Loose coupling via interface-driven listener management

Robust notification calls that continue despite listener exceptions

Adding/removing listeners with encapsulated internal list

Usage demo with anonymous listener classes and error handling

**3. Task Manager: MVC + Events + Inner Classes**

Builds a console-based Task Manager following Model–View–Controller architecture combined with event listeners and inner classes. Highlights:

Model (TaskList) encapsulates tasks and business logic with nested static Task class

Listener interface for notifying about task additions and completion events

Controller mediates user commands with validation and batch operations

View listens to model events to display updates (console output)

Inner class TaskIterator for iterating over tasks

Demonstration wiring all components and illustrating layered interaction

<img width="693" height="217" alt="Screenshot 2025-11-23 at 16 57 40" src="https://github.com/user-attachments/assets/b5921059-03ad-4974-9e49-3929be9e7686" />

**Key Concepts Practiced**
Equality vs identity in Java objects

Defensive and deep copying for immutable data integrity

Observer pattern and event notification

MVC architectural pattern with separation of concerns

Inner and nested classes for encapsulation and structure

**Usage**
Each package contains a demo class with a main method to run and observe behavior interactively.

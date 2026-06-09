# 🏦 Bank Account Service - Core Banking API

**Bank Account Service** est une API REST robuste et évolutive développée avec **Spring Boot**. Ce projet simule le cœur du système d'information d'une banque (Core Banking), permettant la gestion complète des clients, des comptes bancaires (courants et d'épargne) ainsi que l'exécution sécurisée des transactions financières (versements, retraits, virements) avec un suivi historique rigoureux.

---

## 🎬 Démo Vidéo & Aperçu

Voici une démonstration vidéo des fonctionnalités de l'API (tests d'endpoints, exécution de transactions et gestion des exceptions) :




https://github.com/user-attachments/assets/f9da5429-430c-44c7-b3e9-3712e4a9a33d



---

## 🚀 Fonctionnalités Majeures

* **👥 Gestion Clientèle (CRM Basique) :** Création, mise à jour, suppression et consultation des profils clients.
* **💳 Gestion des Comptes :** * Ouverture de comptes bancaires avec attribution d'un identifiant unique (IBAN/UUID).
  * Support de plusieurs types de comptes (Compte Courant avec gestion du découvert, Compte Épargne avec taux d'intérêt).
  * Consultation du solde en temps réel.
* **💸 Moteur de Transactions Sécurisé :**
  * Opérations de débit (Retrait) et de crédit (Versement).
  * Virements de compte à compte avec validation des soldes pour éviter les découverts non autorisés.
  * Approche transactionnelle (`@Transactional`) pour garantir l'atomicité des opérations (si un virement échoue, aucun compte n'est impacté).
* **📜 Historique & Audit :** Archivage systématique de chaque opération avec horodatage, type de transaction, montant et description pour une traçabilité totale.

---

## 🏗️ Architecture & Bonnes Pratiques

Le projet est rigoureusement structuré selon l'architecture en couches standard de l'écosystème Spring, garantissant une séparation stricte des responsabilités :

* **Controllers (REST API) :** Exposition des points d'accès HTTP et validation des requêtes entrantes (DTO pattern).
* **Services (Logique Métier) :** Implémentation des règles de gestion bancaire, des calculs d'intérêts et de la validation des transactions.
* **Repositories (Accès Données) :** Abstraction de la base de données via Spring Data JPA.
* **Exceptions Handler :** Centralisation de la gestion des erreurs (ex: `AccountNotFoundException`, `InsufficientBalanceException`) pour renvoyer des réponses HTTP claires au format JSON.

---

## 🛠️ Stack Technique

* **Framework Principal :** Spring Boot (v3.x)
* **Persistance & Données :** Spring Data JPA / Hibernate
* **Base de Données :** H2 Database (In-Memory pour le développement) / MySQL / PostgreSQL
* **Outils & Qualité :** Lombok (réduction du code passe-partout), Maven (gestionnaire de dépendances)
* **Tests :** Postman (pour la validation des routes API)

---

## 🚦 Installation et Lancement Local

### Prérequis
* **Java Development Kit (JDK)** 17 ou version supérieure.
* **Maven** installé (ou utilisation du wrapper `mvnw` inclus).

### Étapes de configuration

1. **Cloner le dépôt :**
   ```bash
   git clone https://github.com/emna-kaaniche2003/spring-boot-bank-management.git
   cd spring-boot-bank-management

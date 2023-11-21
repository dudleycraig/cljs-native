(ns za.org.functional.store.developer-roles
  (:require
   [clojure.spec.alpha :as s]))

(def DeveloperRoles
  {:software-developer {:name "software-developer" :description "A software developer is someone who designs software and applications that helps users execute specific functions and tasks. They might work on modifying existing software or work to create new offerings. Software developers can also work on systems and networks, helping implement larger frameworks to support specific devices or technologies. Knowledge of coding and coding languages can help software develop candidates apply for specific opportunities. Some employers might also have education or experience requirements for developers in these roles."}
   :web-developer {:name "web-developer" :description "A web developer is someone who works on creating websites for organizations and individuals. They might work on front-end website elements, which are the parts a user sees, or back-end coding, which is the part that controls the primary operations of the site. Web developers often consider website aspects like layout, navigation and accessibility to create websites that meet client requirements and work well for users."}
   :frontend-developer {:name "frontend-developer" :description "A front-end developer works on the user side of an application, program, system or software. Their work helps facilitate successful user experiences. They might adjust the layout of a website, for za.org.functional, or ensure a program is easy to use and navigate. By looking at programs and systems from a user's perspective, front-end developers can help design systems that meet user needs and operate successfully."}
   :backend-developer {:name "backend-developer" :description "A back-end developer is a technology professional that works on the back end of software, applications, programs and systems. The back-end refers to the server side of a program and it controls how systems work. Back-end developers can write code to create programs or change code to facilitate communication between databases and browsers. Back-end developers often write code using specific coding languages. The language they use can depend on the type of project they're working on and the project's function."}
   :fullstack-developer {:name "fullstack-developer" :description "A full-stack developer is a developer that works on both the front end and back end of applications. This means they require knowledge of coding and of user activities. Full-stack developers often receive training that helps them build and create entire applications, programs or software."}
   :mobile-developer {:name "mobile-developer" :description "Mobile developers work specifically on mobile applications and programs. They often create applications optimized for smartphones or tablet use. These developers often specialize in mobile operating systems and they design applications with mobile users in mind. Mobile development can require knowledge of unique languages and coding requirements."}
   :game-developer {:name "game-developer" :description "A game developer is someone who works in video games. Their skills can help them create interactive experiences for users. Game developers might design and build mobile games, computer games, or games for specific operating systems or consoles."}})

(s/def ::key keyword?)
(s/def ::name string?)
(s/def ::description string?)
(s/def ::developer-role (s/keys :req-un [::name ::description]
                                :opt-un []))
(s/def ::developer-roles (s/map-of ::key ::developer-role))

(comment
  (let [DeveloperRole#1
        {:name "developer-role#1 name"
         :description "developer-role#1 description"}
        DeveloperRoles {:developer-role#1 DeveloperRole#1}]
    (and
      (s/valid? ::developer-role DeveloperRole#1)
      (s/valid? ::developer-roles DeveloperRoles))))



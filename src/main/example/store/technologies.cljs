(ns example.store.technologies
  (:require
   [clojure.spec.alpha :as s]))

(def technologies
  {:webgl {:name "webgl" :title "WebGL" :description "" :icon :webgl :months-used 24 :proficiency 6 :current true :usage "" :priority 0}
   :gis {:name "gis" :title "GIS" :description "" :icon :gis :months-used 24 :proficiency 6 :current true :usage "" :priority 0}
   :cljs {:name "cljs" :title "ClojureScript" :description "" :icon :cljs :months-used 24 :proficiency 6 :current true :usage "" :priority 1}
   :clj {:name "clj" :title "Cloure" :description "" :icon :clj :months-used 24 :proficiency 6 :current true :usage "" :priority 1}
   :helix {:name "helix" :title "Helix" :description "" :icon :helix :months-used 24 :proficiency 6 :current true :usage "" :priority 1}
   :reagent {:name "reagent" :title "Reagent" :description "" :icon :reagent :months-used 24 :proficiency 6 :current true :usage "" :priority 2}
   :js {:name "js" :title "JavaScript" :description "" :icon :js :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :ts {:name "ts" :title "TypeScript" :description "" :icon :ts :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :node.js {:name "node.js" :title "Node.js" :description "" :icon :node.js :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :react {:name "react" :title "React" :description "" :icon :react :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :react-native {:name "react-native" :title "React Native" :description "" :icon :react-native :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :redux {:name "redux" :title "Redux" :description "" :icon :redux :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :re-frame {:name "re-frame" :title "Re-Frame" :description "" :icon :re-frame :months-used 24 :proficiency 6 :current true :usage "" :priority 2}
   :firebase {:name "firebase" :title "Firebase" :description "" :icon :firebase :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :express {:name "express" :title "Express" :description "" :icon :express :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :apollo {:name "apollo" :title "Apollo" :description "" :icon :apollo :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :three.js {:name "three.js" :title "Three.js" :description "" :icon :three.js :months-used 24 :proficiency 6 :current true :usage "" :priority 2}
   :r3f {:name "r3f" :title "React Three Fiber" :description "" :icon :r3f :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :zustand {:name "zustand" :title "Zustand" :description "" :icon :zustand :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :d3 {:name "d3" :title "D3" :description "" :icon :d3 :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :tailwindcss {:name "tailwindcss" :title "TailwindCSS" :description "" :icon :tailwindcss :months-used 24 :proficiency 6 :current true :usage "" :priority 1}
   :bootstrap {:name "bootstrap" :title "Bootstrap" :description "" :icon :bootstrap :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :leaflet {:name "leaflet" :title "Leaflet" :description "" :icon :leaflet :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :cesium {:name "cesium" :title "Cesium" :description "" :icon :cesium :months-used 24 :proficiency 6 :current true :usage "" :priority 3}
   :gql-client {:name "gql-client" :title "GraphQL Client" :description "" :icon :gql :months-used 24 :proficiency 6 :current true :usage "" :priority 2}
   :gql-server {:name "gql-server" :title "GraphQL Server" :description "" :icon :gql :months-used 24 :proficiency 6 :current true :usage "" :priority 2}
   :jest {:name "jest" :title "Jest" :description "" :icon :jest :months-used 24 :proficiency 6 :current true :usage "" :priority 4}
   :enzyme {:name "enzyme" :title "Enzyme" :description "" :icon :enzyme :months-used 24 :proficiency 6 :current true :usage "" :priority 4}
   :mocha {:name "mocha" :title "Mocha" :description "" :icon :mocha :months-used 24 :proficiency 6 :current true :usage "" :priority 4}
   :docker {:name "docker" :title "Docker" :description "" :icon :docker :months-used 24 :proficiency 6 :current true :usage "" :priority 4}
   :postgresql {:name "postgresql" :title "PostgreSQL" :description "" :icon :postgresql :months-used 24 :proficiency 6 :current true :usage "" :priority 5}
   :postgis {:name "postgis" :title "PostGIS" :description "" :icon :postgis :months-used 24 :proficiency 6 :current true :usage "" :priority 5}
   :datomic {:name "datomic" :title "Datomic" :description "" :icon :datomic :months-used 24 :proficiency 6 :current true :usage "" :priority 5}
   :mongodb {:name "mongodb" :title "MongoDB" :description "" :icon :mongodb :months-used 24 :proficiency 6 :current true :usage "" :priority 5}
   :mysql {:name "mysql" :title "MySQL" :description "" :icon :mysql :months-used 24 :proficiency 6 :current true :usage "" :priority 5}
   :cassandra {:name "cassandra" :title "Cassandra" :description "" :icon :cassandra :months-used 24 :proficiency 6 :current true :usage "" :priority 5}
   :bash {:name "bash" :title "BASH" :description "" :icon :bash :months-used 24 :proficiency 6 :current true :usage "" :priority 4}
   :blender {:name "blender" :title "Blender" :description "" :icon :blender :months-used 24 :proficiency 6 :current true :usage "" :priority 6}
   :inkscape {:name "inkscape" :title "InkScape" :description "" :icon :inkscape :months-used 24 :proficiency 6 :current true :usage "" :priority 6}
   :gimp {:name "gimp" :title "Gimp" :description "" :icon :gimp :months-used 24 :proficiency 6 :current true :usage "" :priority 6}
   :mobile {:name "mobile" :title "Mobile" :description "" :icon :mobile :months-used 24 :proficiency 6 :current true :usage "" :priority 6}
   :desktop {:name "desktop" :title "Desktop" :description "" :icon :desktop :months-used 24 :proficiency 6 :current true :usage "" :priority 6}
   :java {:name "java" :title "Java" :description "" :icon :java :months-used 24 :proficiency 6 :current true :usage "" :priority 7}
   :hibernate {:name "hibernate" :title "Hibernate" :description "" :icon :hibernate :months-used 24 :proficiency 6 :current true :usage "" :priority 7}
   :spring-boot {:name "spring-boot" :title "Spring Boot" :description "" :icon :spring-boot :months-used 24 :proficiency 6 :current true :usage "" :priority 7}
   :hybris {:name "hybris" :title "Hybris" :description "" :icon :hybris :months-used 24 :proficiency 6 :current true :usage "" :priority 7}
   :jquery {:name "jquery" :title "jQuery" :description "" :icon :jquery :months-used 24 :proficiency 6 :current true :usage "" :priority 7}
   :php {:name "php" :title "PHP" :description "" :icon :php :months-used 24 :proficiency 6 :current true :usage "" :priority 7}
   :python {:name "python" :title "Python" :description "" :icon :python :months-used 24 :proficiency 6 :current true :usage "" :priority 7}
   :perl {:name "perl" :title "Perl" :description "" :icon :perl :months-used 24 :proficiency 6 :current true :usage "" :priority 7}})

(s/def ::key keyword?)
(s/def ::name string?)
(s/def ::title string?)
(s/def ::description string?)
(s/def ::icon keyword?)
(s/def ::months-used int?)
(s/def ::proficiency #(and int? (>= 0) (<= 10)))
(s/def ::current boolean?)
(s/def ::usage string?)
(s/def ::priority #(and int? (>= 0) (<= 10)))
(s/def ::technology (s/keys :req-un [::name ::title ::description ::icon ::months-used ::proficiency ::current ::usage ::priority]
                            :opt-un []))
(s/def ::technologies (s/map-of ::key ::technology))

(comment
  (let [technology-1 {:name "technology-1 name" :title "technology-1 title" :description "technology-1 description" :icon :icon-1 :months-used 24 :proficiency 6 :current true :usage "technology-1 personal usage" :priority 1}
        technology-2 {:name "technology-2 name" :title "technology-2 title" :description "technology-2 description" :icon :icon-2 :months-used 12 :proficiency 1 :current true :usage "technology-2 personal usage" :priority 2}
        technology-3 {:name "technology-3 name" :title "technology-2 title" :description "technology-3 description" :icon :icon-3 :months-used 18 :proficiency 4 :current false :usage "technology-3 personal usage" :priority 3}
        technologies {:technology-1 technology-1
                      :technology-2 technology-2
                      :technology-3 technology-3}]
    (and
      (s/valid? ::technology technology-1)
      (s/valid? ::technology technology-2)
      (s/valid? ::technology technology-3)
      (s/valid? ::technologies technologies))))


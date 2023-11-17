(ns example.providers.app-provider
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text StyleSheet Button]]

            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]))

(def contract-types
  {:full-time       {:description "Full-time contracts are offered to permanent employees who work a full workweek, usually 35 hours or more. These contracts usually include information about benefits, paid holidays, vacation time, sick time and retirement plans. Even further, some full-time contracts present new employees with opportunities for other benefits, like professional development opportunities or workplace perks. Full-time contracts are almost always written contracts since they include many components, and employers normally want to be thorough and clear when offering such an extensive agreement."}
   :part-time       {:description "Part-time contracts are extended to employees who work a reduced number of hours compared to full-time employees. Typically, part-time contracts are offered to those who serve less than 35 hours per week and often include some of the same stipulations and protections as full-time contracts. Many part-time schedules detail the employee's flexibilities, weekly schedule and rate of pay. However, it is important to note that part-time contracts usually do not include information regarding insurance, salary or PTO—all benefits typically reserved for full-time employees."}
   :zero-hour       {:description "Zero-hour contracts are offered to employees who work irregularly or only when work is available. In zero-hour agreements, an employer agrees, in writing or verbally, that they will offer work when it is available, and an employee agrees to work such shifts or remain on call for availability purposes. Zero-hour contracts commonly specify that an employee will work a minimum amount of hours or shifts per month—a number set by the employer in most cases—and that the employee holds the right to refuse any work assignments that may be inopportune.\nZero-hour contracts are often used to hire temporary employees, such as day laborers or babysitters. Unlike full-time and part-time contracts, though, zero-hour contracts do not include information about the standard rate of pay, regular scheduling or benefits, as zero-hour employees are not typically offered such protections."}
   :casual          {:description "Casual contracts are usually extended to employees who work on a seasonal or temporary basis. Through casual contracts, employers typically outline that they will only pay employees for completed work and that the company isn't required to offer a minimum amount of shifts or work hours. In addition, such contracts sometimes state that employees are not mandated to take any shifts or work hours offered.\nCasual contracts offer both employees and employers flexibility in their agreement. However, they are typically only used to specify short-term employment relationships that may or may not be renewed after the duration of employment expires."}
   :freelance       {:description "A freelance contract is typically offered to an employee hired to complete a specific project, such as designing a website, writing an article, taking photos or doing home renovations. Freelance contracts outline the limitations of hours, project details, salary and payment terms. These contracts protect freelancers from receiving late payments or from any project-related challenges that may occur. Freelance contracts do not often include information about benefits like insurance or PTO, as freelancers are usually considered self-employed and sometimes even work other full-time jobs."}
   :fixed-term      {:description "A fixed-term contract is a highly specific and written contract extended to employees who only work for a set amount of time or until they complete a specific task. Fixed-term contracts are commonplace for temporary or contract workers who may take over a job for a specified amount of time or help an organization fill a gap during a time of need.\nFixed-term employees often receive the same benefits and protections as other full-time or part-time employees during their employment tenure, which can be detailed in the contract. Additionally, many fixed-term contracts can lead to permanent contracts once they are up for renewal."}})

(def technologies 
  {:webgl           {:name "webgl" :title "WebGL" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :gis             {:name "gis" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :clojurescript   {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :clojure         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :helix           {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :reagent         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :reframe         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :javascript      {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :typescript      {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :node            {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :react           {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :react-native    {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :redux           {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :re-frame        {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :firebase        {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :express         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :apollo          {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :three.js        {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :r3f             {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :zustand         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :d3              {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :tailwindcss     {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :bootstrap       {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :leaflet         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :cesium          {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :graphql-client  {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :graphql-server  {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :jest            {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :enzyme          {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :mocha           {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :docker          {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :postgresql      {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :postgis         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :mysql           {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :mongodb         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :cassandra       {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :datomic         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :bash            {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :blender         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :inkscape        {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :gimp            {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :mobile          {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :desktop         {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :java            {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :hibernate       {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :spring-boot     {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :hybris          {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :jquery          {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :php             {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :python          {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}
   :perl            {:name "cljs" :title "GIS" :description "" :icon "" :months-used 24 :proficiency 6 :current true :usage ""}})

(def initial-state
  {:employers [{:name "vbt"
                :title "Very Big Things"
                :type :fixed-term
                :duration {:from "2021-10-01" :to "2022-10-01"}
                :role "developer"
                :images {:small [{:src "" :description ""}
                                 {:src "" :description ""}]
                         :medium [{:src "" :description ""}]
                         :large [{:src "" :description ""}]}
                :projects [{:name "odeko"
                            :responsibilities []
                            :technologies {:frontend [] :backend [] :tools []}
                            :images {:small [{:src "" :description ""}
                                             {:src "" :description ""}]
                                     :medium [{:src "" :description ""}]
                                     :large [{:src "" :description ""}]}}]}]})

(defonce AppContext (r/createContext initial-state))

(defn use-context [] (hh/use-context AppContext))

(defnc AppProvider [{:keys [children] :as props}]
  (let [[pages set-pages]   (hh/use-state [])
        add-page            (hh/use-callback [set-pages] #(set-pages (conj pages %)))
        remove-page         (hh/use-callback [set-pages] (fn [page] (set-pages (filter #(not= (get % :name) (get page :name)) pages))))]
    (hc/provider
      {:context AppContext 
       :value {:pages pages :add-page add-page :remove-page remove-page}}
      children)))


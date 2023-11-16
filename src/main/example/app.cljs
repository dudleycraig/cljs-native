(ns example.app
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text StyleSheet Button]]
            ["@react-navigation/native" :as rnn :refer [NavigationContainer]]
            ["@react-navigation/native-stack" :as rnns :refer [createNativeStackNavigator]]
            ["@react-navigation/bottom-tabs" :as rnbt :refer [createBottomTabNavigator]]

            ["tailwind-rn" :refer [TailwindProvider] :as tailwind]
 
            ["expo-status-bar" :refer [StatusBar]]
            [expo.root :refer [render-root]]

            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]))

(def tailwind-json (js/require "../tailwind.json"))

(def state {:property "value"})

(defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
(defonce cljs-splash (js/require "../assets/cljs.png"))

(defonce Stack (createNativeStackNavigator))
(defonce Tab (createBottomTabNavigator))

(defonce AppContext (r/createContext state))

(defnc AppProvider [{:keys [children] :as props}]
  (let [[pages set-pages]   (hh/use-state [])
        add-page            (hh/use-callback [set-pages] #(set-pages (conj pages %)))
        remove-page         (hh/use-callback [set-pages] (fn [page] (set-pages (filter #(not= (get % :name) (get page :name)) pages))))]
    (hc/provider
      {:context AppContext 
       :value {:pages pages :add-page add-page :remove-page remove-page}}
      children)))

(defnc Home [{:keys [navigation route] :as props}]
  (let [tw (tailwind/useTailwind)
        app-context (hh/use-context AppContext)
        page (. route -name)]
    ($ View {:style (tw "pb-12 bg-red-100")}
      ($ Text page))))

(defnc Portfolio [{:keys [navigation route] :as props}]
  (let [tw (tailwind/useTailwind)
        app-context (hh/use-context AppContext)
        page (. route -name)]
    ($ View {:style (tw "pb-12 bg-red-200")}
      ($ Text page))))

(defnc Contact [{:keys [navigation route] :as props}]
  (let [tw (tailwind/useTailwind)
        app-context (hh/use-context AppContext)
        page (. route -name)]
    ($ View {:style (tw "pb-12 bg-red-300")}
      ($ Text page))))

(defnc Resume [{:keys [navigation route] :as props}]
  (let [tw (tailwind/useTailwind)
        app-context (hh/use-context AppContext)
        page (. route -name)]
    ($ View {:style (tw "pb-12 bg-red-400")}
      ($ Text page))))

(defnc Root []
  ($ TailwindProvider {:utilities tailwind-json}
     ($ AppProvider
        ($ NavigationContainer
           ($ Tab.Navigator
              {:id "FooterNavigator"
               :screenOptions (fn [js-params] 
                                (let [navigation   (. js-params -navigation)
                                      route        (. js-params -route)] 
                                  #js {:tabBarLabelStyle #js {:fontSize 18}
                                       :tabBarActiveTintColor "red" 
                                       :tabBarInactiveTintColor "black"
                                       :headerStyle #js {:backgroundColor "rgba(200,200,200,0.2)"}
                                       :headerTitleStyle #js {:fontWeight 900}
                                       :headerRight (fnc [props] ($ Button {:onPress #(js/alert "title button") :title "Title Button" :color "red"}))}))}
              ($ Tab.Screen {:name "home" :options #js {:title "Home"}} Home)
              ($ Tab.Screen {:name "portfolio" :options #js {:title "Portfolio"}} Portfolio)
              ($ Tab.Screen {:name "contact" :options #js {:title "Contact"}} Contact)
              ($ Tab.Screen {:name "resume" :options #js {:title "Resume'"}} Resume))))))

(defn start
  {:dev/after-load true}
  []
  (render-root ($ Root)))

(defn init [] (start))

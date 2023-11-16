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
            [cljs.pprint :as pp :refer [pprint]]

            [example.providers.app-provider :as app-provider :refer [AppProvider]]
            
            [example.screens.home :refer [Home]]
            [example.screens.portfolio :refer [Portfolio]]
            [example.screens.contact :refer [Contact]] 
            [example.screens.resume :refer [Resume]]))

(def tailwind-json (js/require "../tailwind.json"))

(defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
(defonce cljs-splash (js/require "../assets/cljs.png"))

(defonce Stack (createNativeStackNavigator))
(defonce Tab (createBottomTabNavigator))


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

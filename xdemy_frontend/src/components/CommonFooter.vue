
// template + script + style

<template>
  <div class="tab">
    <cube-tab-bar v-model="selectedLabelSlots" @click="changHandler">
      <cube-tab
        v-for="item in tabs"
        :icon="item.icon"
        :label="item.label"
        :key="item.path"
        :value="item.path"
      ></cube-tab>
    </cube-tab-bar>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedLabelSlots: "/",
      tabs: [
        {
          label: "Home",
          icon: "cubeic-home",
          path: "/"
        },
        {
          label: "My Courses",
          icon: "cubeic-like",
          path: "/order"
        },
        {
          label: "Profile",
          icon: "cubeic-person",
          path: "/personal"
        }
      ]
    };
  },

  methods: {
      changHandler(path){
          //this.$route.path is current path
          if(path !== this.$route.path){
              this.$router.push(path)
          }
      }
  },

  created(){
      //default route
      this.selectedLabelSlots = this.$route.path
  }
};
</script>  

<!--SCSS is a pre compile language, scoped means a type of SCSS, only works on this component-->
<style lang="scss" scoped>
.tab {
  position: fixed;
  bottom: 0;
  z-index: 999;
  background-color:#fff;
  width: 100%;
  border-top: 1px solid rgba($color: #000000, $alpha: 0.1);
} 
.cube-tab_active {
  color: #3bb149;
}
</style>
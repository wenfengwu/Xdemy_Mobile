<template>
  <div>
    <cube-slide  :data="carousel">
      <cube-slide-item
        v-for="(item, index) in carousel"
        :key="index">

        <a :href="item.url">
          <img :src="item.img"  style="width:100%"/>
        </a>
      
      </cube-slide-item>
    </cube-slide>
  </div>
</template>

<script>
export default {
    //get data from its parent component, like React props, but diffferent position it puts on component
    props:{
        carousel:{
            type:Array,
            required:true
        }
    }
};
</script>

<style lang="scss" scoped>
</style>
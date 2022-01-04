<template>
    <div class="cate_box">

        <div>
          <!-- nested for loop, chapter list and episode list -->
            <ul class="content" v-for="(item, ind) in chapterList" :key="item.id">
                    <h1> Chapter {{ind +1}} &nbsp;{{item.title}} </h1>

                    <li class="sub_cate" v-for="(item,subind) in chapterList[ind].episode_list" :key="item.id">
                    <span class="sub_title">{{ind+1}}-{{subind+1}} &nbsp;{{item.title}}  </span>    
                    </li>
            </ul>

        </div>

    </div>

</template>

<script>
export default {
    props:{
        chapterList:{
            type:Array,
            required:true
        }
    }

}
</script>

<style lang="scss" scoped>

.cate_box {
  padding: 0 15px 50px;
  background-color: #fff;
  margin: 15px 0;
}


.content {
  padding: 10px;
  //chapter title
  & h1 {
    font-size: 16px;
    width: 100%;
    margin-bottom: 15px;
    font-weight: bolder;
    // hidden title if it is too long
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
  }
}


.sub_cate {
  font-size: 12px;
  padding: 10px 0;

  .sub_title {

    display: block;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
  }
}
</style>
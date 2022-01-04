<template>
    <div>
        <header>
            <div class="header">
                <span @click="$router.back(-1)"> <i class="cubeic-back"></i> </span>
                <div class="title">
                    {{videoInfo.title}}
                </div>
            </div>
        </header>

    </div>
</template>

<script>
export default {
    
    props:{
        videoInfo:{
            type:Object,
            required:true
        }
    }
}
</script>

<style lang="scss" scoped>
    .header {
        display: flex;
        background-color: #07111b;
        padding: 10px 20px;
        color: #fff;
    }  
    //arrow logo
    .cubeic-back {
        color: #fff;
        margin-right:5px;
    }
    //head title
    .title {
        font-size: 16px;
        width: 80%;
        //if overflow, hidden
        text-overflow: ellipsis;
        overflow: hidden;
        white-space: nowrap;
    }
</style>
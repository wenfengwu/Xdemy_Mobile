<template>
  <div class="main">
    <cube-form :model="model" @submit="submitHandler">
      <cube-form-group>

        <cube-form-item :field="fields[0]"></cube-form-item>

        <cube-form-item :field="fields[1]"></cube-form-item>
      </cube-form-group>

      <cube-form-group>
        <cube-button type="submit">Login</cube-button>
      </cube-form-group>
    </cube-form>
    <router-link to="/register" class="reg">Register</router-link>
  </div>
</template>

<script>

import { loginApi } from "@/api/getData.js";
export default {
  data() {
    return {
      model: {
        phoneValue: "",
        pwdValue: "",
      },
      fields: [
        {
          type: "input",
          modelKey: "phoneValue",
          label: "Phone",
          props: {
          placeholder: "Please Enter Phone Number",
          },
          rules: {
            required: true,
          },
          messages: {
            required: "Phone Number is Required",
          },
        },
        {
          type: "input",
          modelKey: "pwdValue",
          label: "Password",
          props: {
            placeholder: "Please Enter Password",
            type: "password",
            eye: {
              open: false,
            },
          },
          rules: {
            required: true,
          },
          messages: {
            required: "Password is Required",
          },
        },
      ],
    };
  },

  methods: {
    submitHandler(e, model) {
      e.preventDefault();

      loginApi(model.phoneValue, model.pwdValue).then((res) => {
        if (res.data.code === 0) {
            //jump to main page after login
            localStorage.setItem("token", res.data.data);

            //set token when login, browser local storage
            this.$store.dispatch("setToken", res.data.data);

            this.$router.push({ path: "/" });
        } else {
          const toast = this.$createToast({
            txt: "Login Failed",
            type: "error",
            time: 1500,
          });
          toast.show();
        }
      });
    },
  },
};
</script>

<style lang="scss" scoped>
.main {
  padding: 50px 5% 0;
  text-align: center;
}

.cube-btn {
  margin-top: 20px;
}

.reg {
  display: inline-block;
  margin-top: 30px;
  font-size: 18px;
}
</style>

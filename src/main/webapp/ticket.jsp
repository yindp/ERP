<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/5/2017
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/color.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/demo/demo.css">
    <script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
</head>
<body>

<s:form action="#" style="width:100%" theme="simple">
    <hr>
    <table cellspacing="15px">

        <tr>
            <td><s:label>Type :</s:label></td>
            <td>
                <select class="easyui-combobox" name="state" style="width:100%;">
                    <option value="SR">Service Request</option>
                    <option value="I">Incident</option>

                </select>
            </td>
            <td><s:label>Create Agent :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td colspan="8">
                <hr>
            </td>
        </tr>
        <tr>
            <td><s:label>Employee ID :</s:label></td>
            <td><s:property value="user.no"/> </td>
            <td><s:label>Name :</s:label></td>
   <%--         <td><s:textfield/></td>--%>
            <td><s:property value="user.name"/> </td>
            <td><s:label>Phone :</s:label></td>
            <td><s:property value="user.phone"/> </td>
            <td><s:label>Email :</s:label></td>
            <td><s:property value="user.email"/> </td>
        </tr>
        <tr>
            <td><s:label>Region :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Country :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Location :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Site :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td><s:label>Company :</s:label></td>
            <td><s:property value="user.company.name"/> </td>
            <td><s:label>Company Code :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Department :</s:label></td>
            <td><s:property value="user.department.name"/> </td>
            <td><s:label>Cost Center :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td colspan="8">
                <hr>
            </td>
        </tr>
        <tr>
            <td><s:label>Main Category :</s:label></td>
            <td>
                <select id="cc1" class="easyui-combobox" name="state" style="width:100%;">
                    <option value="AL">Alabama</option>
                    <option value="AK">Alaska</option>
                    <option value="AZ">Arizona</option>
                    <option value="AR">Arkansas</option>
                    <option value="CA">California</option>
                    <option value="CO">Colorado</option>
                    <option value="CT">Connecticut</option>
                    <option value="DE">Delaware</option>
                    <option value="FL">Florida</option>
                    <option value="GA">Georgia</option>
                    <option value="HI">Hawaii</option>
                    <option value="ID">Idaho</option>
                    <option value="IL">Illinois</option>
                    <option value="IN">Indiana</option>
                    <option value="IA">Iowa</option>
                    <option value="KS">Kansas</option>
                    <option value="KY">Kentucky</option>
                    <option value="LA">Louisiana</option>
                    <option value="ME">Maine</option>
                    <option value="MD">Maryland</option>
                    <option value="MA">Massachusetts</option>
                    <option value="MI">Michigan</option>
                    <option value="MN">Minnesota</option>
                    <option value="MS">Mississippi</option>
                    <option value="MO">Missouri</option>
                    <option value="MT">Montana</option>
                    <option value="NE">Nebraska</option>
                    <option value="NV">Nevada</option>
                    <option value="NH">New Hampshire</option>
                    <option value="NJ">New Jersey</option>
                    <option value="NM">New Mexico</option>
                    <option value="NY">New York</option>
                    <option value="NC">North Carolina</option>
                    <option value="ND">North Dakota</option>
                    <option value="OK">Oklahoma</option>
                    <option value="OR">Oregon</option>
                    <option value="PA">Pennsylvania</option>
                    <option value="RI">Rhode Island</option>
                    <option value="SC">South Carolina</option>
                    <option value="SD">South Dakota</option>
                    <option value="TN">Tennessee</option>
                    <option value="TX">Texas</option>
                    <option value="UT">Utah</option>
                    <option value="VT">Vermont</option>
                    <option value="VA">Virginia</option>
                    <option value="WA">Washington</option>
                    <option value="WV">West Virginia</option>
                    <option value="WI">Wisconsin</option>
                    <option value="WY">Wyoming</option>
                </select>
            </td>
            <td><s:label>Subcategory :</s:label></td>
            <td>
                <select id="cc2" class="easyui-combobox" name="state" style="width:100%;">
                    <option value="AL">Alabama</option>
                    <option value="AK">Alaska</option>
                    <option value="AZ">Arizona</option>
                    <option value="AR">Arkansas</option>
                    <option value="CA">California</option>
                    <option value="CO">Colorado</option>
                    <option value="CT">Connecticut</option>
                    <option value="DE">Delaware</option>
                    <option value="FL">Florida</option>
                    <option value="GA">Georgia</option>
                    <option value="HI">Hawaii</option>
                    <option value="ID">Idaho</option>
                    <option value="IL">Illinois</option>
                    <option value="IN">Indiana</option>
                    <option value="IA">Iowa</option>
                    <option value="KS">Kansas</option>
                    <option value="KY">Kentucky</option>
                    <option value="LA">Louisiana</option>
                    <option value="ME">Maine</option>
                    <option value="MD">Maryland</option>
                    <option value="MA">Massachusetts</option>
                    <option value="MI">Michigan</option>
                    <option value="MN">Minnesota</option>
                    <option value="MS">Mississippi</option>
                    <option value="MO">Missouri</option>
                    <option value="MT">Montana</option>
                    <option value="NE">Nebraska</option>
                    <option value="NV">Nevada</option>
                    <option value="NH">New Hampshire</option>
                    <option value="NJ">New Jersey</option>
                    <option value="NM">New Mexico</option>
                    <option value="NY">New York</option>
                    <option value="NC">North Carolina</option>
                    <option value="ND">North Dakota</option>
                    <option value="OK">Oklahoma</option>
                    <option value="OR">Oregon</option>
                    <option value="PA">Pennsylvania</option>
                    <option value="RI">Rhode Island</option>
                    <option value="SC">South Carolina</option>
                    <option value="SD">South Dakota</option>
                    <option value="TN">Tennessee</option>
                    <option value="TX">Texas</option>
                    <option value="UT">Utah</option>
                    <option value="VT">Vermont</option>
                    <option value="VA">Virginia</option>
                    <option value="WA">Washington</option>
                    <option value="WV">West Virginia</option>
                    <option value="WI">Wisconsin</option>
                    <option value="WY">Wyoming</option>
                </select>
            </td>
            <td><s:label>Subcategory :</s:label></td>
            <td>
                <select id="cc3" class="easyui-combobox" name="state" style="width:100%;">
                    <option value="AL">Alabama</option>
                    <option value="AK">Alaska</option>
                    <option value="AZ">Arizona</option>
                    <option value="AR">Arkansas</option>
                    <option value="CA">California</option>
                    <option value="CO">Colorado</option>
                    <option value="CT">Connecticut</option>
                    <option value="DE">Delaware</option>
                    <option value="FL">Florida</option>
                    <option value="GA">Georgia</option>
                    <option value="HI">Hawaii</option>
                    <option value="ID">Idaho</option>
                    <option value="IL">Illinois</option>
                    <option value="IN">Indiana</option>
                    <option value="IA">Iowa</option>
                    <option value="KS">Kansas</option>
                    <option value="KY">Kentucky</option>
                    <option value="LA">Louisiana</option>
                    <option value="ME">Maine</option>
                    <option value="MD">Maryland</option>
                    <option value="MA">Massachusetts</option>
                    <option value="MI">Michigan</option>
                    <option value="MN">Minnesota</option>
                    <option value="MS">Mississippi</option>
                    <option value="MO">Missouri</option>
                    <option value="MT">Montana</option>
                    <option value="NE">Nebraska</option>
                    <option value="NV">Nevada</option>
                    <option value="NH">New Hampshire</option>
                    <option value="NJ">New Jersey</option>
                    <option value="NM">New Mexico</option>
                    <option value="NY">New York</option>
                    <option value="NC">North Carolina</option>
                    <option value="ND">North Dakota</option>
                    <option value="OK">Oklahoma</option>
                    <option value="OR">Oregon</option>
                    <option value="PA">Pennsylvania</option>
                    <option value="RI">Rhode Island</option>
                    <option value="SC">South Carolina</option>
                    <option value="SD">South Dakota</option>
                    <option value="TN">Tennessee</option>
                    <option value="TX">Texas</option>
                    <option value="UT">Utah</option>
                    <option value="VT">Vermont</option>
                    <option value="VA">Virginia</option>
                    <option value="WA">Washington</option>
                    <option value="WV">West Virginia</option>
                    <option value="WI">Wisconsin</option>
                    <option value="WY">Wyoming</option>
                </select>
            </td>
            <td><s:label>Subcategory :</s:label></td>
            <td>
                <select id="cc4" class="easyui-combobox" name="state" style="width:100%;">
                    <option value="AL">Alabama</option>
                    <option value="AK">Alaska</option>
                    <option value="AZ">Arizona</option>
                    <option value="AR">Arkansas</option>
                    <option value="CA">California</option>
                    <option value="CO">Colorado</option>
                    <option value="CT">Connecticut</option>
                    <option value="DE">Delaware</option>
                    <option value="FL">Florida</option>
                    <option value="GA">Georgia</option>
                    <option value="HI">Hawaii</option>
                    <option value="ID">Idaho</option>
                    <option value="IL">Illinois</option>
                    <option value="IN">Indiana</option>
                    <option value="IA">Iowa</option>
                    <option value="KS">Kansas</option>
                    <option value="KY">Kentucky</option>
                    <option value="LA">Louisiana</option>
                    <option value="ME">Maine</option>
                    <option value="MD">Maryland</option>
                    <option value="MA">Massachusetts</option>
                    <option value="MI">Michigan</option>
                    <option value="MN">Minnesota</option>
                    <option value="MS">Mississippi</option>
                    <option value="MO">Missouri</option>
                    <option value="MT">Montana</option>
                    <option value="NE">Nebraska</option>
                    <option value="NV">Nevada</option>
                    <option value="NH">New Hampshire</option>
                    <option value="NJ">New Jersey</option>
                    <option value="NM">New Mexico</option>
                    <option value="NY">New York</option>
                    <option value="NC">North Carolina</option>
                    <option value="ND">North Dakota</option>
                    <option value="OK">Oklahoma</option>
                    <option value="OR">Oregon</option>
                    <option value="PA">Pennsylvania</option>
                    <option value="RI">Rhode Island</option>
                    <option value="SC">South Carolina</option>
                    <option value="SD">South Dakota</option>
                    <option value="TN">Tennessee</option>
                    <option value="TX">Texas</option>
                    <option value="UT">Utah</option>
                    <option value="VT">Vermont</option>
                    <option value="VA">Virginia</option>
                    <option value="WA">Washington</option>
                    <option value="WV">West Virginia</option>
                    <option value="WI">Wisconsin</option>
                    <option value="WY">Wyoming</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><s:label>Depth of Support :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Impact :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Urgency :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Priority :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td><s:label>Assignment group :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Assigned to :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Master Ticket :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Contact type :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td colspan="2"><s:label>Customer Hardware Required:</s:label></td>
            <td colspan="2"><s:textfield/></td>
            <td><s:label>Parent Incident :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Master Ticket :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td colspan="8"><s:label>Describe :</s:label></td>
        </tr>
        <tr>
            <td colspan="8"><s:textarea rows="4" cols="150"/></td>
        </tr>
    </table>
    <hr>
    <s:submit value="Submit"/><s:submit value="Assign"/>
</s:form>
<s:debug/>
</body>
</html>

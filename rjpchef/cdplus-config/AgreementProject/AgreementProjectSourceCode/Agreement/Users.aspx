<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Users.aspx.cs" Inherits="Agreement.Users" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
<strong>Users</strong>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <div style="font-weight: 700">
        &nbsp;
        <table class="style1">
            <tr>
                <td class="style3">
                    First Name :- *
                </td>
                <td width="20%">
                    <asp:TextBox ID="txtFirstName" runat="server"></asp:TextBox>
                </td>
                <td>
                    &nbsp;
                    </td>
            </tr>
            <tr>
                <td class="style3">
                    <asp:Label ID="lblLastName" runat="server" Text="Last Name :- *"></asp:Label>
                </td>
                <td width="20%">
                    <asp:TextBox ID="txtLastName" runat="server"></asp:TextBox>
                </td>
                <td>
                    &nbsp;
                    <asp:RequiredFieldValidator ID="reqValLastName" runat="server" ControlToValidate="txtLastName"
                        Display="Dynamic" ErrorMessage="Please Enter Last Name" ValidationGroup="Save"
                        ForeColor="Red" SetFocusOnError="True"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="style3">
                    <asp:Label ID="lblPhoneNumber" runat="server" Text="Phone Number :- *"></asp:Label>
                </td>
                <td width="20%">
                    <asp:TextBox ID="txtPhoneNumber" runat="server" MaxLength="10"></asp:TextBox>
                </td>
                <td>
                    &nbsp;
                    <asp:RequiredFieldValidator ID="valReqPhoneNumber" runat="server" ControlToValidate="txtPhoneNumber"
                        Display="Dynamic" ErrorMessage="Please Enter PhoneNumber" ValidationGroup="Save"
                        ForeColor="Red" SetFocusOnError="True"></asp:RequiredFieldValidator>
                    <asp:RegularExpressionValidator ID="regExValidator1" runat="server" ControlToValidate="txtPhoneNumber"
                        Display="Dynamic" ErrorMessage="Should have 10 digits" ForeColor="Red" SetFocusOnError="True"
                        ValidationExpression="\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})" ValidationGroup="Save"></asp:RegularExpressionValidator>
                </td>
            </tr>
            <tr>
                <td class="style3">
                    <asp:Label ID="lblEmail" runat="server" Text="Email :- *"></asp:Label>
                </td>
                <td width="20%">
                    <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
                </td>
                <td>
                    &nbsp;
                    <asp:RequiredFieldValidator ID="valReqEmail" runat="server" ControlToValidate="txtEmail"
                        Display="Dynamic" ErrorMessage="Please Enter Email" ValidationGroup="Save" ForeColor="Red"
                        SetFocusOnError="True"></asp:RequiredFieldValidator>
                    <asp:RegularExpressionValidator ID="valRegExpEmail" runat="server" ControlToValidate="txtEmail"
                        Display="Dynamic" ErrorMessage="Enter Email in proper format." ForeColor="Red"
                        ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" ValidationGroup="Save"></asp:RegularExpressionValidator>
                </td>
            </tr>
            <tr>
                <td class="style3">
                    <asp:Label ID="lblEmpID" runat="server" Text="EmpID :- *"></asp:Label>
                </td>
                <td width="20%">
                    <asp:TextBox ID="txtEmpID" runat="server"></asp:TextBox>
                </td>
                <td>
                    &nbsp;
                    <asp:RequiredFieldValidator ID="valReqEmpID" runat="server" ControlToValidate="txtUserName"
                        Display="Dynamic" ErrorMessage="Please Enter Employee ID" ValidationGroup="Save"
                        ForeColor="Red" SetFocusOnError="True"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="style3">
                    <asp:Label ID="lblUseName" runat="server" Text="UseName :- *"></asp:Label>
                </td>
                <td width="20%">
                    <asp:TextBox ID="txtUserName" runat="server"></asp:TextBox>
                </td>
                <td>
                    &nbsp;
                    <asp:RequiredFieldValidator ID="valReqUserName" runat="server" ControlToValidate="txtUserName"
                        Display="Dynamic" ErrorMessage="Please Enter UserName" ValidationGroup="Save"
                        ForeColor="Red" SetFocusOnError="True"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr id="idPassword" runat="server">
                <td class="style4">
                    <asp:Label ID="lblPassword" runat="server" Text="Password :- *"></asp:Label>
                </td>
                <td width="20%" class="style2">
                    <asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
                </td>
                <td class="style2">
                    &nbsp;
                    <asp:RequiredFieldValidator ID="valReqPassword" runat="server" ControlToValidate="txtPassword"
                        Display="Dynamic" ErrorMessage="Please Enter Password" ValidationGroup="Save"
                        ForeColor="Red" SetFocusOnError="True"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr id="idConfirmPassword" runat="server">
                <td class="style3">
                    <asp:Label ID="lblConfirmPassword" runat="server" Text="Confirm Password :- *"></asp:Label>
                    &nbsp;
                </td>
                <td width="20%">
                    <asp:TextBox ID="txtConfirmPassword" runat="server" TextMode="Password"></asp:TextBox>
                </td>
                <td>
                    &nbsp;
                    <asp:RequiredFieldValidator ID="valReqConfirmPassword" runat="server" ControlToValidate="txtConfirmPassword"
                        Display="Dynamic" ErrorMessage="Please Re-enter Password" ValidationGroup="Save"
                        ForeColor="Red" SetFocusOnError="True"></asp:RequiredFieldValidator>
                    <asp:CompareValidator ID="valComparePassword" runat="server" ControlToCompare="txtPassword"
                        ControlToValidate="txtConfirmPassword" ErrorMessage="Password mismatch." ValidationGroup="Save"
                        ForeColor="Red"></asp:CompareValidator>
                </td>
            </tr>
            <tr>
                <td class="style3">
                    <asp:Label ID="lblUserType" runat="server" Text="User Type :- *"></asp:Label>
                </td>
                <td width="20%">
                    <asp:DropDownList ID="ddlUseType" runat="server">
                        <asp:ListItem Value="" Text="--Select--"></asp:ListItem>
                        <asp:ListItem Value="U" Text="User"></asp:ListItem>
                        <asp:ListItem Value="A" Text="Approver"></asp:ListItem>
                        <asp:ListItem Value="E" Text="Examiner"></asp:ListItem>
                    </asp:DropDownList>
                </td>
                <td>
                    &nbsp;
                    <asp:RequiredFieldValidator ID="valReqUserType" runat="server" ControlToValidate="ddlUseType"
                        Display="Dynamic" ErrorMessage="Select one value from Drop Down Box" ValidationGroup="Save"
                        ForeColor="Red" SetFocusOnError="True"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="style3">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td width="20%">
                    &nbsp;&nbsp;&nbsp;&nbsp;<asp:Button ID="btnSave" runat="server" OnClick="btnSave_Click"
                        Style="height: 26px" Text="Save" ValidationGroup="Save" />
                    &nbsp;&nbsp;
                    <asp:Button ID="btnClear" runat="server" Text="Clear" OnClick="btnClear_Click" />
                </td>
                <td>
                    &nbsp;
                </td>
            </tr>
            <tr>
                <td class="style3">
                    <asp:HiddenField ID="hdnUserID" runat="server" />
                </td>
                <td width="20%">
                    &nbsp;
                </td>
                <td>
                    &nbsp;
                </td>
            </tr>
        </table>
        <asp:GridView ID="dtgUsers" runat="server" AutoGenerateColumns="false" OnRowCommand="dtgUsers_RowCommand"
            HeaderStyle-CssClass="headertext" RowStyle-CssClass="rowstyle" AlternatingRowStyle-CssClass="altrowstyle"
            OnRowDataBound="dtgUsers_RowDataBound" Width="100%" AllowPaging="true" AllowSorting="true"
            PageSize="3" OnPageIndexChanging="dtgUsers_PageIndexChanging" OnSorting="dtgUsers_Sorting">
            <Columns>
                <asp:BoundField HeaderText="First Name" DataField="FirstName" ItemStyle-Width="10%"
                    HeaderStyle-HorizontalAlign="Left" SortExpression="FirstName" />
                <asp:BoundField HeaderText="Last Name" DataField="LastName" HeaderStyle-HorizontalAlign="Left" />
                <asp:BoundField HeaderText="Phone Number" DataField="PhoneNo" HeaderStyle-HorizontalAlign="Left" />
                <asp:BoundField HeaderText="Email" DataField="Email" HeaderStyle-HorizontalAlign="Left" />
                <asp:BoundField HeaderText="Employee ID" DataField="EmpID" HeaderStyle-HorizontalAlign="Left" />
                <asp:BoundField HeaderText="User Name" DataField="UserName" HeaderStyle-HorizontalAlign="Left" />
                <asp:TemplateField HeaderText="User Type" HeaderStyle-HorizontalAlign="Left">
                    <ItemTemplate>
                        <asp:Label ID="lblUserType" runat="server" Text='<%#Eval("UserType") %>'></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Edit/Delete" ControlStyle-Height="25px" ControlStyle-Width="25px">
                    <ItemTemplate>
                        <asp:ImageButton ImageUrl="~/images/edit2.png" ID="lnkbtnEdit" Text="Edit" runat="server"
                            CommandArgument='<%#Eval("UserID") %>' CommandName="E"></asp:ImageButton>
                        &nbsp;&nbsp;
                        <asp:ImageButton ImageUrl="~/images/delete.png" ID="lnkbtnDelete" Text="Delete" runat="server"
                            CommandName="D" CommandArgument='<%#Eval("UserID") %>' OnClientClick="return DeleteRec();">
                        </asp:ImageButton>
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
    </div>
    <script src="Scripts/jquery-1.4.1.js" type="text/javascript"></script>
    <%--<script type="text/javascript">
        $("#btnSave").click(function () {
            if ($("#txtFirstName").val() == '') {
                alert($("#txtFirstName").val());
            }
        }); 
</script>--%>
    <script type="text/javascript">

        function DeleteRec() {
            return confirm('Are you sure, you want to delete?');
        }

        
    </script>
<%--    <script type="text/javascript">
        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        }); 
    </script>


    <script type="text/javascript">
        $(document).ready(function() {
            $("#txtFirstName").validate({
                rules: { 
               <%=txtFirstName.UniqueID %> :{required: true}
                }, messages: {
                    <%=txtFirstName.UniqueID %>:{required: "Full Name"}  
                    }
             });
    </script>--%>
</asp:Content>

<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Home.aspx.cs" Inherits="Agreement.Home" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Home</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <tr>
            <td>
                <strong>My Agreements</strong>
            </td>
        </tr>
        <tr>
            <td>
                <asp:GridView ID="gvAgreementType" runat="server" AutoGenerateColumns="False" Width="100%"
                    DataKeyNames="AgreementTypeID" DataSourceID="SqlDSAgreements" OnSelectedIndexChanged="gvAgreementType_SelectedIndexChanged"
                    OnRowCommand="gvAgreementType_RowCommand" AllowSorting="true" AllowPaging="true"
                    PageSize="5" EmptyDataText="No Records Found." OnRowDataBound="gvAgreementType_RowDataBound">
                    <Columns>
                        <asp:BoundField DataField="AgreementType" HeaderText="Agreement Type" HeaderStyle-CssClass="headertext"
                            SortExpression="AgreementType" ItemStyle-Width="15%" />
                        <asp:BoundField DataField="AgreementTypeID" HeaderText="AgreementTypeID" Visible="false"
                            HeaderStyle-CssClass="headertext" InsertVisible="False" ReadOnly="True" SortExpression="AgreementTypeID" />
                        <asp:BoundField DataField="Title" HeaderText="Title" SortExpression="Title" HeaderStyle-CssClass="headertext"
                            ItemStyle-Width="15%" />
                        <asp:BoundField DataField="WorkType" HeaderText="Work Type" SortExpression="WorkType"
                            HeaderStyle-CssClass="headertext" ItemStyle-Width="15%" />
                        <asp:BoundField DataField="BusinessType" HeaderText="Business Type" SortExpression="BusinessType"
                            HeaderStyle-CssClass="headertext" ItemStyle-Width="15%" />
                       
                        <asp:TemplateField HeaderText="Status" ControlStyle-Height="25px" HeaderStyle-CssClass="headertext" SortExpression="Status"
                            ItemStyle-Width="15%">
                            <ItemTemplate>
                            <asp:Label ID="lblStatus" runat ="server" Text ='<%#Eval("Status") %>'></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:TemplateField HeaderText="Action" ControlStyle-Height="25px" ControlStyle-Width="25px"
                            HeaderStyle-CssClass="headertext" ItemStyle-Width="15%">
                            <ItemTemplate>
                                <asp:LinkButton ID="lnkView" Text="View" runat="server" CommandArgument='<%#Eval("AgreementTypeID")+","+Eval("Status") %>'
                                    CommandName="V" ForeColor="Blue"></asp:LinkButton>
                                &nbsp;
                                <asp:LinkButton ID="lnkDelete" Text="Delete" runat="server" CommandArgument='<%#Eval("AgreementTypeID")+","+Eval("Status") %>'
                                    CommandName="D" ForeColor="Blue"></asp:LinkButton>
                                     &nbsp;&nbsp;&nbsp;
                                <asp:LinkButton ID="lnkStatus" Text="Status" runat="server" CommandArgument='<%#Eval("AgreementTypeID")+","+Eval("Status") %>'
                                    CommandName="S" ForeColor="Blue"></asp:LinkButton>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
            </td>
        </tr>
        <tr>
            <td>
                <strong>My Approvals</strong>
            </td>
        </tr>
        <tr>
            <td>
                <asp:GridView ID="gvApproval" runat="server" AutoGenerateColumns="False" Width="100%"
                    DataSourceID="SqlDataSource1" EmptyDataText="No Records Found." DataKeyNames="ID"
                    OnRowCommand="gvApproval_RowCommand" OnRowDataBound="gvApproval_RowDataBound"
                    AllowSorting="true" AllowPaging="true" PageSize="5">
                    <Columns>
                        <asp:BoundField DataField="ID" HeaderText="ID" Visible="false" SortExpression="ID"
                            InsertVisible="False" ReadOnly="True" HeaderStyle-CssClass="headertext" />
                        <asp:BoundField DataField="UserType" HeaderText="User Type" SortExpression="UserType"
                            ReadOnly="True" HeaderStyle-CssClass="headertext" ItemStyle-Width="15%" />
                        <asp:BoundField DataField="Comments" HeaderText="Comments" SortExpression="Comments"
                            HeaderStyle-CssClass="headertext" ItemStyle-Width="15%" />
                        <asp:BoundField DataField="AgreementType" HeaderText="Agreement Type" ReadOnly="True"
                            SortExpression="AgreementType" HeaderStyle-CssClass="headertext" ItemStyle-Width="15%" />
                        <%-- <asp:BoundField DataField="Title" HeaderText="Title" SortExpression="Title" HeaderStyle-CssClass="headertext" ItemStyle-Width="15%"/>--%>
                          <asp:TemplateField HeaderText="Status" ControlStyle-Height="25px" HeaderStyle-CssClass="headertext" SortExpression="Status"
                            ItemStyle-Width="15%">
                            <ItemTemplate>
                            <asp:Label ID="lblStatus" runat ="server" Text ='<%#Eval("Status") %>'></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:TemplateField HeaderText="Title" HeaderStyle-CssClass="headertext" ItemStyle-Width="15%">
                            <ItemTemplate>
                                <asp:LinkButton ID="Title" Text='<%#Eval("Title")%>' runat="server" CommandArgument='<%#Eval("AgreementTypeID") %>'
                                    CommandName="T" ForeColor="Blue"></asp:LinkButton>
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:TemplateField HeaderText="Action" ControlStyle-Height="25px" ControlStyle-Width="25px"
                            HeaderStyle-CssClass="headertext" ItemStyle-Width="15%">
                            <ItemTemplate>
                                <asp:LinkButton ID="lnkbtnEdit" Text="Edit" runat="server" CommandArgument='<%#Eval("AgreementTypeID")+","+Eval("ID") %>'
                                    CommandName="E" ForeColor="Blue"></asp:LinkButton>
                                &nbsp;
                                <asp:LinkButton ID="lnkbtnView" Text="View" runat="server" CommandArgument='<%#Eval("AgreementTypeID")+","+Eval("ID") %>'
                                    CommandName="V" ForeColor="Blue"></asp:LinkButton>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
                <%--                 SelectCommand="SELECT CASE WHEN [AgreementType] = 'R' THEN 'Registered Vendor'
            WHEN [AgreementType] = 'A' THEN 'Anonymous Agreement' END AS [AgreementType],
             [AgreementTypeID], [Title], 
       CASE WHEN [Status] = 'D' THEN 'Draft'
			WHEN [Status] = 'S' THEN 'Submitted'
            WHEN [Status] = 'A' THEN 'Approved'
			WHEN [Status] = 'R' THEN 'Rejected' END AS [Status],
	   CASE WHEN [WorkType] = 'W' THEN 'Contract Work'
			WHEN [WorkType] = 'C' THEN 'Contractor'
			WHEN [WorkType] = 'S' THEN 'Subcontract Services'  END AS [WorkType],
			Business.BusinessType
         FROM [AgreementType] as Agreement 
         join DDLBusinessType as Business ON agreement.BusinessTypeID = Business.BusinessTypeID
         WHERE   ([UserID] = @UserID) order by SubmittedDate desc">--%>
                <asp:SqlDataSource ID="SqlDSAgreements" runat="server" ConnectionString="<%$ ConnectionStrings:AgreementConnectionString %>"
                    SelectCommand="SELECT CASE WHEN AgreementType = 'R' THEN 'Registered Vendor'
            WHEN [AgreementType] = 'A' THEN 'Anonymous Agreement' END AS [AgreementType],
             [AgreementTypeID], [Title], 
       CASE WHEN [Status] = 'D' THEN 'Draft'
			WHEN [Status] = 'S' THEN 'Submitted'
            WHEN [Status] = 'A' THEN 'Approved'
			WHEN [Status] = 'R' THEN 'Rejected' END AS [Status],
	   CASE WHEN [WorkType] = 'W' THEN 'Contract Work'
			WHEN [WorkType] = 'C' THEN 'Contractor'
			WHEN [WorkType] = 'S' THEN 'Subcontract Services'  END AS [WorkType],
	   	CASE AgreementType When 'R' then Null
	   	     when 'A' then (select BusinessType from DDLBusinessType where [AgreementType].BusinessTypeID = DDLBusinessType.BusinessTypeID ) END as BusinessType
         FROM [AgreementType] 
         WHERE   ([UserID] = @UserID) order by SubmittedDate desc">
                    <SelectParameters>
                        <asp:SessionParameter DefaultValue="1" Name="UserID" SessionField="UsersID" Type="Int32" />
                    </SelectParameters>
                </asp:SqlDataSource>
                <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:AgreementConnectionString %>"
                    SelectCommand="SELECT ID, CASE WHEN [UserType] = 'A' THEN 'Agreement Reviewer'
        WHEN [UserType] = 'B' THEN 'Business Reviewer'
        WHEN [UserType] = 'L' THEN 'Lawyer Approver'
        ELSE 'Other Approver' END AS [UserType]
        , [Comments],A.AgreementTypeID AS AgreementTypeID,
    CASE WHEN A.[Status] = 'D' THEN 'Draft'
         WHEN A.[Status] = 'R' THEN 'Rejected' 
         WHEN A.[Status] = 'A' THEN 'Approved' END AS [Status],
     CASE WHEN A.[Status] = 'D' THEN 1
         WHEN A.[Status] = 'R' THEN 2 
         WHEN A.[Status] = 'A' THEN 2 END AS [StatusOrder],
    CASE WHEN AgreementType = 'R' THEN 'Registered Vendor' ELSE 'Anonymous Agreement' END AS AgreementType, Title
    FROM [Approval] A
    JOIN dbo.AgreementType AT ON A.AgreementTypeID = AT.AgreementTypeID
    WHERE ([Approver] = @Approver) ORDER BY StatusOrder,ID Desc">
                    <SelectParameters>
                        <asp:SessionParameter DefaultValue="1" Name="Approver" SessionField="UsersID" Type="Int32" />
                    </SelectParameters>
                </asp:SqlDataSource>
            </td>
        </tr>
    </table>
</asp:Content>

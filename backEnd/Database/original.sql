USE [master]
GO
/****** Object:  Database [FPB]    Script Date: 6/16/2015 1:40:45 AM ******/
CREATE DATABASE [FPB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FPB', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\FPB.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'FPB_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\FPB_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [FPB] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FPB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FPB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FPB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FPB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FPB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FPB] SET ARITHABORT OFF 
GO
ALTER DATABASE [FPB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [FPB] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [FPB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FPB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FPB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FPB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FPB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FPB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FPB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FPB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FPB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [FPB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FPB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FPB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FPB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FPB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FPB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FPB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FPB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [FPB] SET  MULTI_USER 
GO
ALTER DATABASE [FPB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FPB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FPB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FPB] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [FPB]
GO
/****** Object:  Table [dbo].[tb_Field]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Field](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_StadiumId] [int] NOT NULL,
	[c_Number] [nvarchar](5) NOT NULL,
	[c_FieldType] [int] NOT NULL,
	[c_IsActive] [bit] NOT NULL,
	[c_FieldPriceId] [int] NOT NULL,
 CONSTRAINT [PK_tb_Field] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_FieldPrice]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_FieldPrice](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_StadiumId] [int] NOT NULL,
	[c_FieldPriceName] [nvarchar](50) NOT NULL,
	[c_FieldPriceDescription] [nvarchar](200) NULL,
 CONSTRAINT [PK_tb_FieldPrice] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_JoinSystemRequest]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_JoinSystemRequest](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_UserId] [int] NOT NULL,
	[c_FullName] [nvarchar](50) NOT NULL,
	[c_Address] [nvarchar](100) NOT NULL,
	[c_Phone] [nvarchar](20) NOT NULL,
	[c_Email] [nvarchar](50) NOT NULL,
	[c_StadiumName] [nvarchar](100) NOT NULL,
	[c_StadiumAddress] [nvarchar](100) NOT NULL,
	[c_Note] [nvarchar](1000) NULL,
	[c_Status] [nvarchar](50) NOT NULL,
	[c_CreateDate] [datetime] NOT NULL,
 CONSTRAINT [PK_tb_JoinSystemRequest] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_PriceTable]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_PriceTable](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_FieldPriceId] [int] NOT NULL,
	[c_Day] [int] NULL,
	[c_Slot] [int] NOT NULL,
	[c_Price] [float] NOT NULL,
 CONSTRAINT [PK_tb_PriceTable] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_Reservation]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Reservation](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_FieldId] [int] NOT NULL,
	[c_FullName] [nvarchar](50) NOT NULL,
	[c_PhoneNumber] [nvarchar](20) NOT NULL,
	[c_Email] [nvarchar](50) NULL,
	[c_Date] [date] NOT NULL,
	[c_Price] [float] NOT NULL,
	[c_VerifyCode] [nvarchar](50) NOT NULL,
	[c_CreatedDate] [datetime] NOT NULL,
 CONSTRAINT [PK_tb_Reservation] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_Role]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Role](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_Role] [nvarchar](50) NOT NULL,
	[c_DisplayName] [nvarchar](50) NULL,
 CONSTRAINT [PK_tb_Role] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_Slot]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Slot](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_Slot] [int] NOT NULL,
	[c_Description] [nchar](30) NULL,
 CONSTRAINT [PK_tb_Slot] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_Stadium]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Stadium](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_Name] [nvarchar](100) NOT NULL,
	[c_Street] [nvarchar](50) NOT NULL,
	[c_Ward] [nvarchar](50) NOT NULL,
	[c_District] [nvarchar](50) NOT NULL,
	[c_Phone] [nvarchar](20) NOT NULL,
	[c_Email] [nvarchar](100) NOT NULL,
	[c_IsActive] [bit] NOT NULL,
	[c_MainOwner] [int] NOT NULL,
 CONSTRAINT [PK_tb_Stadium] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_StadiumImage]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_StadiumImage](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_StadiumId] [int] NOT NULL,
	[c_Path] [nvarchar](100) NOT NULL,
	[c_Title] [nvarchar](100) NULL,
	[c_Caption] [nvarchar](200) NULL,
 CONSTRAINT [PK_tb_StadiumImage] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_StadiumRating]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_StadiumRating](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_UserId] [int] NOT NULL,
	[c_StadiumId] [int] NOT NULL,
	[c_Rate] [float] NOT NULL,
 CONSTRAINT [PK_tb_StadiumRating] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_StadiumReview]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_StadiumReview](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_UserId] [int] NOT NULL,
	[c_StadiumId] [int] NOT NULL,
	[c_ReviewContent] [nvarchar](500) NOT NULL,
	[c_IsApproved] [bit] NOT NULL,
	[c_Approver] [int] NULL,
	[c_CreateDate] [datetime] NOT NULL,
 CONSTRAINT [PK_tb_StadiumReview] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_StadiumStaff]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_StadiumStaff](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_UserId] [int] NOT NULL,
	[c_StadiumId] [int] NOT NULL,
	[c_IsOwner] [bit] NOT NULL,
 CONSTRAINT [PK_tb_StadiumStaff] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_User]    Script Date: 6/16/2015 1:40:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_User](
	[c_Id] [int] IDENTITY(1,1) NOT NULL,
	[c_UserName] [nvarchar](50) NOT NULL,
	[c_Password] [nvarchar](50) NOT NULL,
	[c_FullName] [nvarchar](50) NULL,
	[c_Address] [nvarchar](100) NULL,
	[c_PhoneNumber] [nvarchar](20) NULL,
	[c_Email] [nvarchar](50) NOT NULL,
	[c_JoinDate] [date] NOT NULL,
	[c_IsActive] [bit] NOT NULL,
	[c_RoleId] [int] NULL,
 CONSTRAINT [PK_tb_User] PRIMARY KEY CLUSTERED 
(
	[c_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[tb_User] ADD  CONSTRAINT [DF_Table_1_IsActive]  DEFAULT ((1)) FOR [c_IsActive]
GO
ALTER TABLE [dbo].[tb_Field]  WITH CHECK ADD  CONSTRAINT [FK_tb_Field_tb_FieldPrice] FOREIGN KEY([c_FieldPriceId])
REFERENCES [dbo].[tb_FieldPrice] ([c_Id])
GO
ALTER TABLE [dbo].[tb_Field] CHECK CONSTRAINT [FK_tb_Field_tb_FieldPrice]
GO
ALTER TABLE [dbo].[tb_Field]  WITH CHECK ADD  CONSTRAINT [FK_tb_Field_tb_Stadium] FOREIGN KEY([c_StadiumId])
REFERENCES [dbo].[tb_Stadium] ([c_Id])
GO
ALTER TABLE [dbo].[tb_Field] CHECK CONSTRAINT [FK_tb_Field_tb_Stadium]
GO
ALTER TABLE [dbo].[tb_FieldPrice]  WITH CHECK ADD  CONSTRAINT [FK_tb_FieldPrice_tb_Stadium] FOREIGN KEY([c_StadiumId])
REFERENCES [dbo].[tb_Stadium] ([c_Id])
GO
ALTER TABLE [dbo].[tb_FieldPrice] CHECK CONSTRAINT [FK_tb_FieldPrice_tb_Stadium]
GO
ALTER TABLE [dbo].[tb_JoinSystemRequest]  WITH CHECK ADD  CONSTRAINT [FK_tb_JoinSystemRequest_tb_User] FOREIGN KEY([c_UserId])
REFERENCES [dbo].[tb_User] ([c_Id])
GO
ALTER TABLE [dbo].[tb_JoinSystemRequest] CHECK CONSTRAINT [FK_tb_JoinSystemRequest_tb_User]
GO
ALTER TABLE [dbo].[tb_PriceTable]  WITH CHECK ADD  CONSTRAINT [FK_tb_PriceTable_tb_FieldPrice] FOREIGN KEY([c_FieldPriceId])
REFERENCES [dbo].[tb_FieldPrice] ([c_Id])
GO
ALTER TABLE [dbo].[tb_PriceTable] CHECK CONSTRAINT [FK_tb_PriceTable_tb_FieldPrice]
GO
ALTER TABLE [dbo].[tb_PriceTable]  WITH CHECK ADD  CONSTRAINT [FK_tb_PriceTable_tb_Slot] FOREIGN KEY([c_Slot])
REFERENCES [dbo].[tb_Slot] ([c_Id])
GO
ALTER TABLE [dbo].[tb_PriceTable] CHECK CONSTRAINT [FK_tb_PriceTable_tb_Slot]
GO
ALTER TABLE [dbo].[tb_Reservation]  WITH CHECK ADD  CONSTRAINT [FK_tb_Reservation_tb_Field] FOREIGN KEY([c_FieldId])
REFERENCES [dbo].[tb_Field] ([c_Id])
GO
ALTER TABLE [dbo].[tb_Reservation] CHECK CONSTRAINT [FK_tb_Reservation_tb_Field]
GO
ALTER TABLE [dbo].[tb_Stadium]  WITH CHECK ADD  CONSTRAINT [FK_tb_Stadium_tb_User] FOREIGN KEY([c_MainOwner])
REFERENCES [dbo].[tb_User] ([c_Id])
GO
ALTER TABLE [dbo].[tb_Stadium] CHECK CONSTRAINT [FK_tb_Stadium_tb_User]
GO
ALTER TABLE [dbo].[tb_StadiumImage]  WITH CHECK ADD  CONSTRAINT [FK_tb_StadiumImage_tb_Stadium] FOREIGN KEY([c_StadiumId])
REFERENCES [dbo].[tb_Stadium] ([c_Id])
GO
ALTER TABLE [dbo].[tb_StadiumImage] CHECK CONSTRAINT [FK_tb_StadiumImage_tb_Stadium]
GO
ALTER TABLE [dbo].[tb_StadiumRating]  WITH CHECK ADD  CONSTRAINT [FK_tb_StadiumRating_tb_Stadium] FOREIGN KEY([c_StadiumId])
REFERENCES [dbo].[tb_Stadium] ([c_Id])
GO
ALTER TABLE [dbo].[tb_StadiumRating] CHECK CONSTRAINT [FK_tb_StadiumRating_tb_Stadium]
GO
ALTER TABLE [dbo].[tb_StadiumRating]  WITH CHECK ADD  CONSTRAINT [FK_tb_StadiumRating_tb_User] FOREIGN KEY([c_UserId])
REFERENCES [dbo].[tb_User] ([c_Id])
GO
ALTER TABLE [dbo].[tb_StadiumRating] CHECK CONSTRAINT [FK_tb_StadiumRating_tb_User]
GO
ALTER TABLE [dbo].[tb_StadiumReview]  WITH CHECK ADD  CONSTRAINT [FK_tb_StadiumReview_tb_Stadium] FOREIGN KEY([c_StadiumId])
REFERENCES [dbo].[tb_Stadium] ([c_Id])
GO
ALTER TABLE [dbo].[tb_StadiumReview] CHECK CONSTRAINT [FK_tb_StadiumReview_tb_Stadium]
GO
ALTER TABLE [dbo].[tb_StadiumReview]  WITH CHECK ADD  CONSTRAINT [FK_tb_StadiumReview_tb_User] FOREIGN KEY([c_UserId])
REFERENCES [dbo].[tb_User] ([c_Id])
GO
ALTER TABLE [dbo].[tb_StadiumReview] CHECK CONSTRAINT [FK_tb_StadiumReview_tb_User]
GO
ALTER TABLE [dbo].[tb_StadiumReview]  WITH CHECK ADD  CONSTRAINT [FK_tb_StadiumReview_tb_User1] FOREIGN KEY([c_Approver])
REFERENCES [dbo].[tb_User] ([c_Id])
GO
ALTER TABLE [dbo].[tb_StadiumReview] CHECK CONSTRAINT [FK_tb_StadiumReview_tb_User1]
GO
ALTER TABLE [dbo].[tb_StadiumStaff]  WITH CHECK ADD  CONSTRAINT [FK_tb_StadiumOwner_tb_Stadium] FOREIGN KEY([c_StadiumId])
REFERENCES [dbo].[tb_Stadium] ([c_Id])
GO
ALTER TABLE [dbo].[tb_StadiumStaff] CHECK CONSTRAINT [FK_tb_StadiumOwner_tb_Stadium]
GO
ALTER TABLE [dbo].[tb_StadiumStaff]  WITH CHECK ADD  CONSTRAINT [FK_tb_StadiumOwner_tb_User] FOREIGN KEY([c_UserId])
REFERENCES [dbo].[tb_User] ([c_Id])
GO
ALTER TABLE [dbo].[tb_StadiumStaff] CHECK CONSTRAINT [FK_tb_StadiumOwner_tb_User]
GO
ALTER TABLE [dbo].[tb_User]  WITH CHECK ADD  CONSTRAINT [FK_tb_User_tb_Role] FOREIGN KEY([c_RoleId])
REFERENCES [dbo].[tb_Role] ([c_Id])
GO
ALTER TABLE [dbo].[tb_User] CHECK CONSTRAINT [FK_tb_User_tb_Role]
GO
USE [master]
GO
ALTER DATABASE [FPB] SET  READ_WRITE 
GO

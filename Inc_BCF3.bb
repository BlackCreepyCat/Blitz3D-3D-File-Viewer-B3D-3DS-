;=======================================================================================
; Code : BCF Librairie (GUI pour Blitz3D)		
; Project Title :
; Author : Philippe Agnisola et Nicolas Poursin (C)opyRight 2003  ! do not distribute !
; Email :                    
; Version : 3.0 Shareware
; Date :              
; Notes : 
;                   
;                   
;=======================================================================================

Include "Inc_BCF3 Res.bb"

; ----------
; To do :
; ----------
; Make background bitmap for inputbox
; Make le disable for the input box and listbox

;It would be good to have a function that checks:
;if users are typing in the specified input box.  Returns 1
;if they have finished and aren't typing in it. Returns 0

; Faire un fonction pour virer tout les tooltip

; --------------------------------
; Worklog version 3.102
; --------------------------------
; - Added new command   	: A default filename in the file requester.
; - Added new command   	: BCF_SelectedListBoxValue( Id , label$ ) you can choose the selected listbox item.
; - Added new command   	: BCF_TestWindowsMinimized(Id) return if a window is minimized.
; - Added new command   	: BCF_MinimizeWindow(Id) minimize one window.
; - Added new command   	: BCF_MaximizeWindow(Id) maximize one window.

; --------------------------------
; Worklog version 3.101
; --------------------------------
; - Added new graphics  		: FileRequester have drive icon. 
; - Added new graphics  		: Messagebox have icon. BCF_MsgBox(Title$,Message$,RequestType=0,IconNumber=1)

; - Added new command   	: BCF_LockWindow(WinID,True or False) for lock a window
; - Added new command   	: BCF_EnableGadget(GadgetID, True or False) for disable or enable a button, checkbox,bitmapbutton,slider,scrollbar, combobox
; - Added new command   	: BCF_SetVisible(GadgetId, True or False) for hide or show a control
; - Added new command   	: BCF_GetLabelTextLabel$(Id) get the labeltext label (thanks OrcEpic)
; - Added new command   	: BCF_DisableButtonTooltip(Id) Disable a button tooltip.
; - Added new command   	: BCF_DisableBitmapButtonTooltip(Id) Disable a bitmap button tooltip.

; - Added new command   	: The file and the path requester combobox have only available drive ...

; - Bug removed 				: In gauge calculation...
; - Bug removed 				: In scrollbar calculation...
; - Bug removed 				: Tooltip and listbox ...

; ---------------------------
; Worklog version 3.1
; ---------------------------
; - Graphics Changes ! You can make more easily, your hown gfx under BCF
; - Major optimisation : By using handle for detecting button message (Thanks Pigmin)

; -----------------------------
; Worklog version 3.08
; -----------------------------
; - Change in the file requester you can now choose many file extensions !!! example :
;   Selecteur$=BCF_FileRequester("Open picture", "Ok", "Cancel",".*|.jpeg|.gif|.bmp|.tga|.pcx|.png")
;
; - Added new command : BCF_CreateBitmapButtonToolTip(ButtonID,ToolTip$)
; - Added new command : BCF_CreateButtonToolTip(ButtonID,ToolTip$)

; - Added new command : BCF_PathRequester$( Title$="",ButtonValidate$="",ButtonCancel$="",FileReqPath$="")

; -----------------------------
; Worklog version 3.07
; -----------------------------
; - Inputbox are not limited by size ! (Thanks Pigmin) the new parameter's are :
;   BCF_CreateInputBox(WinId,Px,Py,Label$,MaxLen,CapsOnly,Type_Input,MaxVisChar)


; -----------------------------
; Worklog version 3.06
; -----------------------------
; - Bug removed in the filerequester when folder have the same name that his parent folder
; - Bug removed in the image control, now the image with black color are not transparent 
; - Bug removed if you don't specify filename an image is created
; - Bug removed in the Regenerate BCF Function, eat many memory .... resolved
; - Added new command : BCF_ChangeImageBuffer( Id,Buffer) you can change an image control by an image buffer


; -----------------------------
; Worklog version 3.05
; -----------------------------
; - Minor bug removed in Combobox
; - Added new command : BCF_ChangeSliderMax(Id,Max) for change the max slider value
; - Added new command : BCF_ChangeBitmapButtonBitmap(Id,Bitmap$) you can change on the fly the bitmap in a bitmap button

; - Added new command : BCF_CreateMenu( Caption$ ,State )
; - Added new command : BCF_CreateMenuItem ( MenuID ,Caption$)
; - Added new command : BCF_CreateSubMenu( MenuItemID )

; - Added new command : BCF_EnableMenu( MenuID )
; - Added new command : BCF_DisableMenu(MenuID)

; - Added new command : BCF_ShowMenuItem(MenuItemID)
; - Added new command : BCF_HideMenuItem(MenuItemID)

; - Added new command : BCF_EnableMenuItem(MenuItemID)
; - Added new command : BCF_DisableMenuItem(MenuItemID)

; - Added new command : BCF_CreatePopUpMenu()
; - Added new command : BCF_SetPopupMenu( PopUpMenuID )


; -----------------------------
; Worklog version 3.04
; -----------------------------
; - Added ColorGadget() See example : Exemple - BCF Simple Color Button.bb

; - Bug removed in the filerequester when a drive is unselectable, the msgbox freeze.
; - Bug removed in the function ChangeCheckBoxState and ChangeCheckBoxLabel (old ChangeCkeck with a K)
; - Big big bug removed ! when some controls are directly on the screen, and when you click on the screen,the control appear in the foreground
; 
; - Added 3D viewport ! :) See example : BCF Simple Viewport.bb and new command.
;   BCF_CreateViewport( WinId,Px,Py,Tx,Ty ,CamPosX#,CamPosY#,CamPosZ#,CamPitch#,CamYaw#,CamRoll#)
;   BCF_UpdateViewPort()
;   BCF_KillIViewPort( Id)
;
; - Added new command : BCF_WindowIsActive(Id) test if a window is active return True or False


; -----------------------------
; Worklog version 3.03
; -----------------------------
; - Added 3 BCF GUI Style :) with command BCF_InitGui(3,2,GuiStyle) :
;   GuiStyle 1 = 3D normal
;   GuiStyle 2 = 3D with nice gradient (Maybe slow with many slider ...)
;   GuiStyle 3 = 2D flatten (very speed redrawing and more professional look ... i hope ?)
;
; - Many graphics bug resolved !
;
; - Added two new commands : BCF_ChangeButtonPosition(Id,Px,Py) & BCF_ChangeBitmapButtonPosition(Id,Px,Py)
;   used for moving button and bitmap button to new position.


; -----------------------------
; Worklog version 3.02
; -----------------------------
; - Scheme/Canva bug resolved (when windows are minimized changing the scheme, destroy windows body).
; - Viewport problem (if gadget size < text size) corrected for Slider,Scrollbar,Window,InfoText.
; - Added Exemple - BCF Simple Icon Button.bb + Bitmap convertion tool.


; -----------------------------
; Worklog version 3.01
; -----------------------------
; - Global added BCF_GuiStyle, You can know what is the BCF style by dumping the BCF_GuiStyle variable (ex : print BCF_GuiStyle)
; - BCF_InitGui() have a new parameter added (ex BCF_InitGui(3,2,1)) see Readme.htm
;
; Added :
; -----------
; - Old BCF 2.0 mouse pointer style 3 added (know as style 7) 


; ------------------------------------
; Worklog de la version 3.00
; ------------------------------------
; Serieuse optimisation des assets graphiques ! sous la forme d'image, les gadgets concerné sont :
; - Boutons
; - Slider
; - Icon
; - ComboBox
; - ListBox
; - Checkbox
; - Image
; - Bitmap Button
; - ScollBar
; - Slider
; - Frame
;
; De ce fait pas mal de routines ont sautés, genre DrawIcons etc ..
; - Ajout de la routine BCF_RegenerateBCF() qui permet de redessiner les gadgets en images
; - Ajout de la commande BCF_TestLastWindow() qui quand elle renvoi true indque qu'il ni a plus de fenêtres à l'ecran
; - Changement des pointeurs de souris de 1 à 6
; - Changement des icones des fenêtres et de gadgets de reduction/fermeture (gestion bitmap)
; - Un ptetit relooking discret a été fait en plus ...


; -------------------------------------
; Worklog de la version 2.09
; -------------------------------------
; - Ajout du parametrage de l'ouverture du file requester
; - Modification des noms des globals du file requester
; - Ajout de l'affichage du path sur le file requester
; - Correction du click sur les icon button et le bitmap button
;
; - Ajout des commandes pour les bitmaps boutons :
;		BCF_CreateBitmapButton(WinId,Px,Py,Bitmap$,Style=1)
;		BCF_TestBitmapButton(Id)
;		BCF_TestBitmapButtonPressed(Id)
;
;		BCF_KillBitmapButtonChild(IdWin)
;		BCF_KillBitmapButton(Id)
;
; - Ajout du style 0 (sans pointeur) pour le pointeur de la souris BCF_Init3DMouse() qui permet d'effacer le pointeur
;
; - Ajout des schemes numéro 6,7,8 et creation du scheme editor
;

; -------------------------------------
; Worklog de la version 2.08
; -------------------------------------
; - Ajout de la commande BCF_TestListBoxItemNumber( Id ) qui permet de connaitre le nombre d'items d'une listbox

; -------------------------------------
; Worklog de la version 2.07
; -------------------------------------
; - Modification du sélecteur de fichier pour qu'il s'ouvre sur le dernier répertoire selectionné.
; - Ajout de la localisation anglaise et française.

; -------------------------------------
; Worklog de la version 2.06
; -------------------------------------
; - Modification des arguments du sélecteur de fichier  BCF_FileRequester$( Title$ ,ButtonValidate$,ButtonCancel$,Ext$).
; - Ajout du filetype dans le sélecteur de fichier  (genre ".exe").

; -------------------------------------
; Worklog de la version 2.05
; -------------------------------------
; - Correction du bug entre les combobox et les scrollbar.
; - Ajout de la commande BCF_MouseOnWindows permettant de connaitre si la souris se trouve sur une fenêtre.
; - Ajout de la commande BCF_ChangeImageBitmap() qui permet de change l'image d'un controle image.
; - Ajout de la global BCF_MouseZSpeed permet de connaitre la vitesse de rotation de la roulette de la souris.
; - Ajout de la gestion de la roulette de la souris dans les listBox , combobox , scrollBar et sélecteur de fichier.
; - Les listeBox ComboBox FileRequester et Scroll réagisent au click dans l'encadrement de l'ascenceur.
; - Correction du bug d'affectation d'une valeur à un scrollbox avec un pas <0 et une valeur<0.
; - Ajout d'un style au Frame (optionel).
; - Fermeture des combobox par click droit.
; - Correction du probleme d'affichage des frames sur la fenetre virtuelle.
; - Correction du check intenpestif des checkbox.
; - Ajoute de la fonction BCF_MouseOnWindows()permettant de savoir si la souris se trouve sur une fenetre ou non.
; - La fonction BCF_InitBCF reinitialise toutes les variables.

; -------------------------------------
; Worklog de la version 2.04
; -------------------------------------
;	- Ajout de la commande BCF_CreateFrame() qui permet de créer des Frames 3D avec label.
;	- Ajout de la commande BCF_KillFrame() qui permet d'effacer une Frame 3D.
;	- Ajout de la commande BCF_ChangeFrameLabel() qui permet de changer le label d'une Frame 3D.

; -------------------------------------
; Worklog de la version 2.03
; -------------------------------------
; * Correction de bug :
;
; 	- Fixe du probleme de selection intenpestive de controle lorsque que le bouton gauche de la souris est enfoncé.
; 	- Optimisation des checkbox pour les machines puissantes (le click n'etait pas toujours pris la premiere fois).
;	- Fixe du probleme de creation de fenetre en cours de programme (la fenetre cree n'etait pas active par defaut).
;
;	* Amelioration :
;
; 	- Modification du design des ScrollBar.
; 	- Ajout d'un style au bouton des Scrollbar.
; 	- Augmentation de la taille minimale du bouton des ascenseur des listbox, combox et Scrollbar.
;
; * Nouvelle fonctionnalites
;	 - Ajout de la commande BCF_MinimizeAllWindow() qui permet de réduire toutes les fenêtres a l'ecran.
;	 - Ajout des parametres optionels icon=-1 et nType=-1 dans les fonctions BCF_AddComboBocItem et BCF_AddListBoxItem
;   	ils permettent d'afficher un icon devant un item et d'attache un valeur numerique à un Item.
;
;	Cette valeur numerique de l'item selectionne est interrogeable pour les commandes ;
;	- BCF_TestListBoxType( Id )
;	- BCF_TestComboBoxType( Id )
;
;	- Ajout de la commande : BCF_MaximizeAllWindow() qui permet de maximiser toutes les fenêtres
;	- Ajout de la commande : BCF_MinimizeAllWindow() qui permet de minimiser toutes les fenêtres

; -------------------------------------
; Worklog de la version 2.02
; -------------------------------------
; - Ajout d'un paramètre de couleur sur les LabelText et de la fonction (BCF_ChangeLabelTextColor(Id,Red,Green,Blue)).
; - Ajout de la commande BCF_TestButtonPressed qui permet de savoir si un bouton est pressé.
; - Optimisation de la fonction CreateImage, on ne resize plus l'image si la taille du cadre est égale a la taille de l'image.
; - Ajout des ScrollBar.
; - Optimisation des Sliders (résultats plus précis).

; -------------------------------------
;  Worklog de la version 2.01
; -------------------------------------
;  - Modification des sliders

; ----------------------------------------
; Globale de la version de BCF
; ----------------------------------------
Global BCF_Version$="3.00"

Global BCF_Localization
Global BCF_GuiStyle

Global BCF_FileRequestTitle$
Global BCF_FileRequestValidate$
Global BCF_FileRequestCancel$
Global BCF_FileRequestDrive$
Global BCF_FileRequestCreate$
Global BCF_FileRequestSelected$
Global BCF_FileRequestAlertMsg$
Global BCF_FileRequestExt$

Global BCF_PathRequestTitle$
Global BCF_PathRequestValidate$
Global BCF_PathRequestCancel$
Global BCF_PathRequestSelected$
Global BCF_PathRequestDrive$

Global BCF_MsgBoxOk$
Global BCF_MsgBoxYes$
Global BCF_MsgBoxNo$
Global BCF_MsgBoxCancel$
Global BCF_MsgBoxClear$

Global BCF_AboutBCFTitle$
Global BCF_AboutBCFText$

Const BCF_DriveType_NOTPRESENT		= 1
Const BCF_DriveType_REMOVEABLE	= 2
Const BCF_DriveType_HARDDISK			= 3
Const BCF_DriveType_NETWORK          = 4
Const BCF_DriveType_CDROM				= 5
Const BCF_DriveType_RAMDISK            = 6
Const BCF_DriveType_UNKNOWN          = 7


; -------------------------------
; Globales des couleurs
; -------------------------------
Global Bcf_Color00
Global Bcf_Color01
Global Bcf_Color02
Global Bcf_Color03
Global Bcf_Color04
Global Bcf_Color05
Global Bcf_Color06
Global Bcf_Color07
Global Bcf_Color08
Global Bcf_Color09

; --------------------------------
; Global du file requester
; --------------------------------
Global BCF_Drive$ 
Global BCF_Old_Drive$=""
Global BCF_Folder$=""
Global BCF_Old_Folder$=""
Global BCF_Path$
Global BCF_bPath=False

; --------------------------------------------------
; Globales des evenements de la GUI
; --------------------------------------------------
Global BCF_WindowMove = False
Global BCF_WindowActive

; ------------------------------
; Globales de la souris
; ------------------------------
Global BCF_MousePointer
Global BCF_MouseStyle
Global BCF_MouseFlag=0 		; Variable qui permet de savoir si le pointeur et affiché a l'écran

Global BCF_MouseZSpeed

Global BCF_MouseX
Global BCF_MouseY

Global BCF_MouseClicked_X =-1
Global BCF_MouseClicked_Y =-1

Global BCF_MouseRealClick_L = False
Global BCF_MouseClicked_L = False
Global BCF_MouseRelease_L = False
Global BCF_MouseOld_L = False

Global BCF_DblClickTimer
Global BCF_DblClick =0



Global BCF_MouseClicked_XR =-1
Global BCF_MouseClicked_YR =-1

Global BCF_MouseRealClick_R = False
Global BCF_MouseClicked_R = False
Global BCF_MouseRelease_R = False
Global BCF_MouseOld_R = False



; ---------------------------------
; Globales pour les fontes
; ---------------------------------
Global BCF_InterfaceFont
Global BCF_InputBoxFont

; ---------------------------------------
; Globales de la fenetre virtuel
; ---------------------------------------
Global BCF_VirtualP = False		
Global BCF_IdVirtualParent = -1
Global BCF_HaVirtualParent= -1

; -------------------------------------
; Globales pour les inputBox
; -------------------------------------
Global BCF_InputBoxFocus = False
Global BCF_InputBoxCursorPos
Global BCF_InputBoxTimer
Global BCF_InputBoxTextPos = 0
Global BCF_LastFocusId = -1

; ----------------------------------------
; Globales pour les ComboBox
; ----------------------------------------
Global BCF_ComboVisible
Global BCF_IdComboVisible
Global BCF_ComboSelection = False

; ----------------------------------
; Globales pour les listbox
; ----------------------------------
Global BCF_ListTimer
Global BCF_ClikLeftTimer

; -----------------------------
; Global des viewports
; -----------------------------
Global BCF_TViewPort

; ---------------------------------------------
; Global et constantes des menus
; ---------------------------------------------
Global BCF_Menu = False							; Indique si la gestion des menus fixes est actif ou non
Global BCF_MenuActif = False					; indique si le menu est en cours d'utilisation
Global BCF_MenuPopUpActif = False			; Indique si un popup menu est en cours d'utilisation
Global BCF_MenuPopUpCurrent=-1			; Contient l'Id du popup a afficher
Global BCF_MenuSelection = False

Global BCF_MenuPopUpPx						; position X,Y et Taill X,Y
Global BCF_MenuPopUpPy						; ou le click droit permettra d'afficher le popup
Global BCF_MenuPopUpTx							
Global BCF_MenuPopUpTy							

Global BCF_MenuNextx								; Permet le positionnement de titre de menus dans la barre de menu

Const BCF_MenuMenu = 1				
Const BCF_MenuSubMenu = 2
Const BCF_MenuPopUp = 3

Const BCF_MenuItem = 1
Const BCF_MenuItemSubMenu = 2
Const BCF_MenuItemSeparator = 3

Const BCF_MenuNoPopup = -1					; Permet de desactive le popupmenu en utilisant  la fonction   BCF_SetMenuPopup( BCF_MenuNoPopup )

; ------------------------------------------------------------------------------------------------------------------------------------------
; Gestion des requester (True si la fenetre est exclusive, False permet la selection des autres fenêtres
; ------------------------------------------------------------------------------------------------------------------------------------------
Global BCF_Requester = False

; -----------------------------------------------------------------------------------------------------------
; Variable permettant de connaitre la valeur du scheme de couleur en cours
; -----------------------------------------------------------------------------------------------------------
Global BCF_ColorScheme=0

; -------------------------
; Type des couleurs
; -------------------------
Type BCF_TColor
	Field R,G,B
End Type

; -------------------------
; Type des fenêtres
; -------------------------
Type TWindow
	Field Id
	Field Icon
	Field BackGround1
	Field BackGround2
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field Style
	Field Move
	Field Active
	Field Label$
	Field WIdthDragX%	; Stock la longeur Active de la barre de titre pour le deplacement
	Field DragX%
	Field DragY%
	Field Id_close				; Sotck l'Id du bouton de fermeture
	Field Id_reduction		; Stock l'Id du bouton de reduction
	Field State					; 0=normal ; 1=reduite
	
	Field Visible
	Field Locked
End Type

; ----------------------------
; Type des frames 3D
; ----------------------------
Type TFrame
	Field Id
	Field WinId
	Field BackGround
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field Label$
	Field Style
	
	Field Visible
End Type

; -------------------------
; Type des boutons
; -------------------------
Type TButton
	Field Id
	Field WinId
	Field ButtonState1
	Field ButtonState2
	
	Field ButtonState3
	
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field ButtonState
	Field Label$
	Field ToolTip$
	Field Click
	Field Style
	
	Field Visible
	Field Enable
End Type

; -----------------------------------
; Type des boutons bitmap
; -----------------------------------
Type TBitmapButton
	Field Id
	Field WinId
	Field ButtonState1
	Field ButtonState2
	
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field ButtonState
	
	Field Bitmap
	Field BitmapDisable
	
	Field ToolTip$
	Field Click
	Field Style
	
	Field Visible
	Field Enable
End Type

; -------------------------------
; Type des boutons icon
; -------------------------------
Type TIcon
	Field Id
	Field WinId
	Field ButtonState1
	Field ButtonState2
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field ButtonState
	
	Field Icon
	Field IconDisable
	
	Field Click
	Field Style
	
	Field Visible
	Field Enable
End Type

; -----------------------
; Type des slIders
; -----------------------
Type TSlIder
	Field Id
	Field WinId
	
	Field BackGround
	Field BackGroundDisable

	Field Px
	Field Py
	Field Tx
	Field Ty
	Field State
	Field Min#
	Field Max#
	Field Value#
	Field Integer
	Field Flag
	Field Label$
	Field Style
	Field Red
	Field Green
	Field Blue
	
	Field Visible
	Field Enable
End Type

; --------------------------
; Type des ScrollBar
; --------------------------
Type TScrollBar
	Field Id
	Field WinId
	
	Field BackGround
	Field BackGroundDisable
	
	Field Px
	Field Py
	Field Tx
	Field Ty

	Field ScrollTx
	Field ScrollTy
	
	Field Min#
	Field Max#
	
	Field Pas#
	Field NbPas#
	Field Longueur_pas#

	Field IndexScroll
	Field Slider_Move
	Field Slider_x
	Field Slider_w
	Field Drag_x

	Field Id_ascenseur
	
	Field Red
	Field Green
	Field Blue

	Field Value#

	Field Label$
	Field DrawLabel
	
	Field Visible
	Field Enable
End Type

; ---------------------------
; Type des checkbox
; ---------------------------
Type TCheckbox
	Field Id
	Field WinId
	Field BackGround1
	Field BackGround2
	
	Field BackGround3
	Field BackGround4
	
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field State
	Field Label$
	
	Field Visible
	Field Enable
End Type

; ---------------------------
; Type des TextLabel
; ---------------------------
Type TTextLabel
	Field Id
	Field WinId
	Field Px
	Field Py
	Field Label$
	Field Align
	Field Style
	Field Red
	Field Green
	Field Blue
	
	Field Visible
End Type

; -----------------------------
; Type des ComboBox
; -----------------------------
Type TComboBox
	Field Id
	Field WinId
	Field BackGround1
	Field BackGround2
	Field ListId
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field ListH
	Field Id_down
	Field Selection$
	Field Type_Selection
	
	Field Visible
	Field Enable
End Type

; -----------------------
; Type des ListBox
; -----------------------
Type TListBox
	Field Id					
	Field WinId
	Field BackGround1
	Field BackGround2
	Field ListId
	Field Indexitem
	Field Px
	Field Py
	Field Tx
	Field Ty

	Field ListTx
	Field ListTy
	
	Field Id_up
	Field Id_down
	Field Id_ascenseur
	
	Field Indexscroll
	Field Nb_item
	Field Nb_itemvisible
	
	Field Nb_pas
	Field Hauteur_pas#

	Field SlIder_Y#
	Field SlIder_H#
	Field SlIder_move
	Field DragY

	Field Index_selection
	Field Selection$
	Field Type_Selection
	
	Field Visible
	
	Field Combo
	
	Field VisibleNotCombo
End Type

; ------------------------
; Type des gauges
; ------------------------
Type TGauge
	Field Id
	Field WinId
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field Value
	Field Max
	Field Label$
	Field Style
	Field Red
	Field Green
	Field Blue
	
	Field Visible
End Type

; --------------------------
; Type des infos text
; --------------------------
Type TInfoText
	Field Id
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field Style
	Field Label$
	
	Field Visible
End Type

; -------------------------
; Type des inputbox
; -------------------------
Type TInputBox
	Field Id
	Field WinId
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field Label$
	Field MaxLen
	Field CapsOnly
	Field Actif
	Field Type_Input
	Field MaxVisChar
	
	Field Visible
End Type

; ------------------------------------
; Type des Item des ListBox
; ------------------------------------
Type TItem
	Field Id
	Field Id_list
	Field index
	Field label$
	Field icon
	Field nType
End Type

; ------------------------
; Type des images
; ------------------------
Type TImage
	Field Id
	Field WinId
	Field BackGround
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field Image
	
	Field Visible
End Type

; ----------------------
; Type des Timer
; ----------------------
Type TTimer
	Field Start
	Field TimeOut
End Type

; -------------------------
; Type des viewport
; -------------------------
Type TBCF_ViewPort
	Field Id
	Field WinId
	Field px
	Field py
	Field tx
	Field ty
	Field camera
	Field image
	
	Field Visible
End Type

; --------------------------
; Les types du menu
; --------------------------
Type TMenu
	Field TypeMenu											; Type du menue
	Field Label$													; Label du menu afficher dans la barre du menus
	Field Px
	Field Py
	Field Tx
	Field Ty
	Field TxMax													; Stock ma plus grandeur largeur d'item
	Field nbItem													; Nombre d'item
	Field Enabled												; Actif ou non
	Field Open													; Visible ou non
	Field hMenuParent										; Dans le cas d'un sous menu => l'id du menu parent
	Field hItemChild											; Dans le cas d'un sous menu => l'id de l'item du menu parent faisant reference a ce menus
End Type

; -----------------------------------------
; Les types des items du menu
; -----------------------------------------
Type TMenuItem
	Field hParent												;  Id du Menus pour cette Item
	Field TypeItem												; Type de l'item
	Field label$													; Label de l'item
	Field Enabled												; Actif ou non
	Field visible													; Visible ou non

	Field highlights											; Item faisant lien vers un popup munu en selection ou non
	Field hSubMenu											; Id du sous menu
	Field ImgSubMark										; Stocke l'image qui permet de declarer un sous menu

	Field selected												; Cliquer ou non
End Type

; --------------------------------
; Innitialisation de la GUI
; --------------------------------
Function BCF_AboutBCF()
	HalfWIdth=GraphicsWidth()/2
	HalfHeight=GraphicsHeight()/2

	; --------------------------------------
	; Mise en forme du requester
	; --------------------------------------
	RequestWIdth=330
	RequestHeight=188	
	ButtonTx=60

	; -----------------------------------------------------------
	; Definition de la position X et Y du requester
	; -----------------------------------------------------------
	Px=HalfWIdth-(RequestWIdth/2)
	Py=HalfHeight-(RequestHeight/2)
	
	Requester=BCF_CreateWindow(Px,Py,RequestWIdth,RequestHeight,BCF_GuiStyle,3,BCF_AboutBCFTitle$,True,False)

	; ------------------------------------------
	; On desactive toute les fenêtres
	; ------------------------------------------
	For BCF.TWindow =Each TWindow
		BCF\Active=False
	Next
	
	; ----------------------------------------		
	; La dialog est la fenetre Active
	; ----------------------------------------
	BCF.TWindow = Last TWindow
	BCF_WindowActive = Handle( BCF )
	BCF\Active = True
	
	; ------------------------------
	; Creation des boutons
	; ------------------------------
	Label= BCF_CreateLabelText(Requester,RequestWIdth/2,15,"BCF build "+BCF_Version$+" "+BCF_AboutBCFText$,2,1,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))
	Ok=BCF_CreateButton(Requester,RequestWIdth/2-(ButtonTx/2)-2,RequestHeight-55,ButtonTx,20,"Ok",BCF_GuiStyle)

	; ----------------------------------------------------------
	; On bloque la selection des autres fenêtres
	; ----------------------------------------------------------
	BCF_Requester = True
	BCF_RequestReturn=-1

	While  BCF_RequestReturn=-1
		If BCF_TestButton(Ok) Then
			BCF_RequestReturn=0
		EndIf

		UpdateWorld
		RenderWorld
		
		; -------------------------------------------
		; Rafraichissement de l'interface
		; -------------------------------------------
		BCF_RenderBCF()

		Flip
	Wend

	BCF_KillWindow(BCF\Id)
	BCF_Requester=False
End Function 

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; --------------------------------
; Innitialisation de la GUI
; --------------------------------
Function BCF_InitBCF(Langage=1,GuiStyle=2)

	; ----------------------------------------------
	; Reinitialisation des variables BCF
	; ----------------------------------------------
	BCF_Requester=False
	BCF_VirtualP = False		
	BCF_IdVirtualParent = -1
	BCF_HaVirtualParent= -1
	BCF_InputBoxFocus = False
	BCF_ComboSelection = False
	FirstTime=True

	; --------------------------------
	; Chargement des fontes
	; --------------------------------
	BCF_InterfaceFont=LoadFont("Arial",15,1,0,0) 
	BCF_InputBoxFont=LoadFont("Courier",13,0,0,0)

	; -----------------------------
	; Application du theme
	; -----------------------------
	BCF_InitScheme(GuiStyle)

	; -----------------
	; Localisation
	; -----------------
	Select Langage
	Case 1 ; Francais
		BCF_FileRequestTitle$="Ouvrir un fichier"
		BCF_FileRequestValidate$="Valider"
		BCF_FileRequestCancel$="Annuler"
		BCF_FileRequestDrive$="Choix du lecteur"
		BCF_FileRequestCreate$="Créer un répertoire"
		BCF_FileRequestSelected$="Fichier sélectionné : "
		BCF_FileRequestAlertMsg$=" ne répond pas !"
		BCF_FileRequestExt$="Extension(s)"

		BCF_PathRequestTitle$="Selectionner un chemin"
		BCF_PathRequestValidate$="Valider"
		BCF_PathRequestCancel$="Annuler"
		BCF_PathRequestSelected$="Chemin sélectionné : "
		BCF_PathRequestDrive$="Choix du lecteur"

		BCF_AboutBCFTitle$="A propos de BCF ..."
		BCF_AboutBCFText$="(C)2003 tous droits reservés||Par Philippe Agnisola et Nicolas Poursin||Ce programme est un shareware.|http://www.blitz3dfr.com"

		BCF_MsgBoxOk$="Ok"
		BCF_MsgBoxYes$="Oui"
		BCF_MsgBoxNo$="Non"
		BCF_MsgBoxCancel$="Annuler"
		BCF_MsgBoxClear$="Effacer"

		BCF_Localization=1
	Case 2 ; Anglais
		BCF_FileRequestTitle$="File open"
		BCF_FileRequestValidate$="Open"
		BCF_FileRequestCancel$="Cancel"
		BCF_FileRequestDrive$="Select one drive"
		BCF_FileRequestCreate$="Create directory"
		BCF_FileRequestSelected$="Selected file : "
		BCF_FileRequestAlertMsg$=" is not a valid drive !"
		BCF_FileRequestExt$="Extension(s)"

		BCF_PathRequestTitle$="Select Path"
		BCF_PathRequestValidate$="Select"
		BCF_PathRequestCancel$="Cancel"
		BCF_PathRequestSelected$="Selected path : "
		BCF_PathRequestDrive$="Select one drive"
		
		BCF_AboutBCFTitle$="About BCF ..."
		BCF_AboutBCFText$="(C)opyright 2003 all rights reserved||By Philippe Agnisola and Nicolas Poursin||This program is shareware.|http://www.blitz3dfr.com"

		BCF_MsgBoxOk$="Ok"
		BCF_MsgBoxYes$="Yes"
		BCF_MsgBoxNo$="No"
		BCF_MsgBoxCancel$="Cancel"
		BCF_MsgBoxClear$="Clear"
		
		BCF_Localization=2
	End Select

	BCF_GuiStyle=GuiStyle
End Function

; ------------------------------------------------------------------------------------------------------
; Fonction qui permet de fermer la BCF et de rendre la mémoire proprement
; ------------------------------------------------------------------------------------------------------
Function BCF_KillBCF()
	For BCF.TWindow = Each TWindow
		BCF_KillWindow( BCF\Id )
	Next

	FreeFont BCF_InterfaceFont
	FreeFont BCF_InputBoxFont

	BCF_FreeMenu( )
	BCF_Kill3DMouse()
End Function

; -------------------------------
; Affichage de l'interface
; -------------------------------
Function BCF_RenderBCF()
	BCF_RenderWindow()
	BCF_RenderMouse()
End Function

; --------------------------------------------------------
; Fonction gerant la visibilite des controles
; --------------------------------------------------------
Function BCF_SetVisible(Id, bVisible = True)
	TMP_TWindow.TWindow = Object.TWindow(Id)
	TMP_TFrame.TFrame = Object.TFrame(Id)
	TMP_TButton.TButton = Object.TButton(Id)
	TMP_TBitmapButton.TBitmapButton = Object.TBitmapButton(Id)
	TMP_TIcon.TIcon = Object.TIcon(Id)
	TMP_TSlIder.TSlIder = Object.TSlIder(Id)
	TMP_TScrollBar.TScrollBar = Object.TScrollBar(Id)
	TMP_TCheckbox.TCheckbox = Object.TCheckbox(Id)
	TMP_TTextLabel.TTextLabel = Object.TTextLabel(Id)
	TMP_TComboBox.TComboBox = Object.TComboBox(Id)
	TMP_TListBox.TListBox = Object.TListBox(Id)
	TMP_TGauge.TGauge = Object.TGauge(Id)
	TMP_TInfoText.TInfoText = Object.TInfoText(Id)
	TMP_TInputBox.TInputBox = Object.TInputBox(Id)
	TMP_TImage.TImage = Object.TImage(Id)
	TMP_TBCF_ViewPort.TBCF_ViewPort = Object.TBCF_ViewPort(Id)
	
	Select (True)
		Case (TMP_TWindow <> Null)
			TMP_TWindow\Visible = bVisible
		Case (TMP_TFrame <> Null)
			TMP_TFrame\Visible = bVisible
		Case (TMP_TButton <> Null)
			TMP_TButton\Visible = bVisible	
		Case (TMP_TBitmapButton <> Null)
			TMP_TBitmapButton\Visible = bVisible
		Case (TMP_TIcon <> Null)
			TMP_TIcon\Visible = bVisible
		Case (TMP_TSlIder <> Null)
			TMP_TSlIder\Visible = bVisible
		Case (TMP_TScrollBar <> Null)
			TMP_TScrollBar\Visible = bVisible
		Case (TMP_TCheckbox <> Null)
			TMP_TCheckbox\Visible = bVisible
		Case (TMP_TTextLabel <> Null)
			TMP_TTextLabel\Visible = bVisible
		Case (TMP_TComboBox <> Null)
			TMP_TComboBox\Visible = bVisible
		Case (TMP_TListBox <> Null)
			TMP_TListBox\VisibleNotCombo = bVisible
		Case (TMP_TGauge <> Null)
			TMP_TGauge\Visible = bVisible
		Case (TMP_TInfoText <> Null)
			TMP_TInfoText\Visible = bVisible
		Case (TMP_TInputBox <> Null)
			TMP_TInputBox\Visible = bVisible
		Case (TMP_TImage <> Null)
			TMP_TImage\Visible = bVisible
		Case (TMP_TBCF_ViewPort <> Null)
			TMP_TBCF_ViewPort\Visible = bVisible	
	End Select
End Function

; --------------------------------------------------------
; Fonction gerant la visibilite des controles (Pour le moment Button, BitmapButton,Icon,Checkbox,ComboBox)
; --------------------------------------------------------
Function BCF_EnableGadget(Id, bEnable = True)
	TMP_TButton.TButton = Object.TButton(Id)
	TMP_TBitmapButton.TBitmapButton = Object.TBitmapButton(Id)
	TMP_TIcon.TIcon = Object.TIcon(Id)
	TMP_TSlIder.TSlIder = Object.TSlIder(Id)
	TMP_TScrollBar.TScrollBar = Object.TScrollBar(Id)
	TMP_TCheckbox.TCheckbox = Object.TCheckbox(Id)
	TMP_TComboBox.TComboBox = Object.TComboBox(Id)
	
	Select (True)
		Case (TMP_TButton <> Null)
			TMP_TButton\Enable = bEnable
		Case (TMP_TBitmapButton <> Null)
			TMP_TBitmapButton\Enable = bEnable
		Case (TMP_TIcon <> Null)
			TMP_TIcon\Enable = bEnable
		Case (TMP_TSlIder <> Null)
			TMP_TSlIder\Enable = bEnable
		Case (TMP_TScrollBar <> Null)
			TMP_TScrollBar\Enable = bEnable
		Case (TMP_TCheckbox <> Null)
			TMP_TCheckbox\Enable = bEnable
		Case (TMP_TComboBox <> Null)
			TMP_TComboBox\Enable = bEnable
	End Select
End Function

; -------------------------------------------------------------------------------------------
; Permet de créer une image grisé a partir de l'image d'un control
; -------------------------------------------------------------------------------------------
Function BCF_CreateDisableControl(Img,DrawOnImage=True)
	Local TMP_DisableImage=CreateImage(ImageWidth(Img),ImageHeight(Img))

	; ----------------------------
	; Creation de la grille
	; ----------------------------
	SetBuffer ImageBuffer(TMP_DisableImage)
	Color 0,0,0 : Cls
	BCF_Color(Bcf_Color09) : Plot 0,0 : Plot 1,1

	For x=0 To ImageWidth(TMP_DisableImage) Step 2
		For y=0 To ImageHeight(TMP_DisableImage) Step 2
			CopyRect 0,0,2,2,x,y 
		Next
	Next

	; ----------------------------------------------------------------------------------------------------------------
	; Si on ecrit sur l'image cible on mixe les deux sinon on retourne l'image temporaire
	; ----------------------------------------------------------------------------------------------------------------
	If DrawOnImage=True Then 
		; -----------------------------------------------------
		; On passe sur le buffer de destination
		; -----------------------------------------------------
		SetBuffer ImageBuffer(Img)

		; ----------------------------------------
		; On pose la grille sur l'image
		; ----------------------------------------
		DrawImage TMP_DisableImage,0,0

		; -------------------------------------------------------------
		; Liberation de la memoire et swap du buffer
		; -------------------------------------------------------------
		SetBuffer BackBuffer()
		FreeImage TMP_DisableImage
	Else
		SetBuffer BackBuffer()
		Return TMP_DisableImage
	EndIf 
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Function BCF_DisableButtonTooltip(Id)
	BCF.TButton = Object.TButton(Id)
	If (BCF <> Null)
		BCF\ToolTip$=""
	EndIf
End Function

Function BCF_DisableBitmapButtonTooltip(Id)
	BCF.TBitmapButton = Object.TBitmapButton (Id)
	If (BCF <> Null)
		BCF\ToolTip$=""
	EndIf
End Function

; ---------------------------------------------------------
; Affichage des tooltips des gadgets button
; ---------------------------------------------------------
Function BCF_RenderButtonToolTip(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	 For BCF.TButton = Each TButton
		; -------------------------------------------------------------
	 	; Recuperation du handle de la fenetre parent
		; -------------------------------------------------------------		
	 	If (BCF\WinId = ParentWindow\Id And BCF\Visible) Then
			; --------------------------------------------------------------------------------------------------------------------------------------------------------
			; On traite le bouton si l'State de la fenetre est 0 (non réduite) ou si c'est les boutons de fermeture et de reduction
			; --------------------------------------------------------------------------------------------------------------------------------------------------------
			If  ParentWindow\State=0  Or  (BCF\Id=ParentWindow\Id_close Or BCF\Id=ParentWindow\Id_reduction)  Then
			
				TmpX= BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
				TmpY= BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre
				
				; --------------------------
				; Affichage du tooltip
				; --------------------------
				If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx+2 , BCF\Ty+2 ) And BCF\ToolTip$<>"" And BCF_MenuActif <>True Then
					SetFont  BCF_InterfaceFont
					ToolTipLen=StringWidth(BCF\ToolTip$)+21
					
					BCF_ToolPX=MouseX()+2
					BCF_ToolPY=MouseY()+2
					
					BCF_Draw3dBar( BCF_ToolPX+20,BCF_ToolPY+20,ToolTipLen,17,1,	BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
					BCF_Draw3dBar( BCF_ToolPX+20,BCF_ToolPY+20,15,17,1,	BCF_GetRed(Bcf_Color04),BCF_GetGreen(Bcf_Color04), BCF_GetBlue(Bcf_Color04))

					Color 200,180,80
					Text  BCF_ToolPX+25,BCF_ToolPY+22,"?"
										
					Color BCF_GetRed(Bcf_Color08),BCF_GetGreen(Bcf_Color08), BCF_GetBlue(Bcf_Color08)
					Text  BCF_ToolPX+39,BCF_ToolPY+22,BCF\ToolTip$
				EndIf
			EndIf
		EndIf 
	Next
End Function

; -------------------------------------------------------------------
; Affichage des tooltips des gadgets bitmap button
; -------------------------------------------------------------------
Function BCF_RenderBitmapButtonToolTip(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)

	For BCF.TBitmapButton = Each TBitmapButton
		; --------------------------------------------------
	 	; Par defaut le bouton n'est pas activé
		; -------------------------------------------------
	 	If (BCF\WinId = ParentWindow\Id And BCF\Visible) Then
			; ------------------------------------------------------------------------------------------------------------------------------------------------------
			; On traite le bouton si l'State de la fenetre est 0 (non réduite) ou si c'est les boutons de fermeture et de reduction
			; ------------------------------------------------------------------------------------------------------------------------------------------------------
			If  ParentWindow\State=0  Or  (BCF\Id=ParentWindow\Id_close Or BCF\Id=ParentWindow\Id_reduction) Then
			
				TmpX= BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
				TmpY= BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre

				; --------------------------
				; Affichage du tooltip
				; --------------------------
				If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx+2 , BCF\Ty+2 ) And BCF\ToolTip$<>"" And BCF_MenuActif <>True Then
					SetFont  BCF_InterfaceFont
					ToolTipLen=StringWidth(BCF\ToolTip$)+21
					
					BCF_ToolPX=MouseX()+2
					BCF_ToolPY=MouseY()+2
					
					BCF_Draw3dBar( BCF_ToolPX+20,BCF_ToolPY+20,ToolTipLen,17,1,	BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
					BCF_Draw3dBar( BCF_ToolPX+20,BCF_ToolPY+20,15,17,1,	BCF_GetRed(Bcf_Color04),BCF_GetGreen(Bcf_Color04), BCF_GetBlue(Bcf_Color04))

					Color 200,180,80
					Text  BCF_ToolPX+25,BCF_ToolPY+22,"?"
										
					Color BCF_GetRed(Bcf_Color08),BCF_GetGreen(Bcf_Color08), BCF_GetBlue(Bcf_Color08)
					Text  BCF_ToolPX+39,BCF_ToolPY+22,BCF\ToolTip$
				EndIf
			EndIf			
		EndIf
	Next 
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ------------------------------------------------
; Regeneration du fond des gadgets
; ------------------------------------------------
Function BCF_RegenerateBCF()
	; ---------------------------------------------------------------------------------------------------------------------------------------
	; Ouverture de toutes les fenetres sinon destruction du body de la fenetre quand on change le theme
	; ---------------------------------------------------------------------------------------------------------------------------------------
	BCF_MaximizeAllWindow()
	
	; ----------------------------------------------------------
	; On refais les images du fond des boutons
	; ----------------------------------------------------------
	For TMP1.TButton=Each TButton
		FreeImage TMP1\ButtonState1
		FreeImage TMP1\ButtonState2
			
		TMP1\ButtonState1=BCF_DrawButton(0,0,TMP1\Tx,TMP1\Ty,1,TMP1\Label$,TMP1\Style)
		TMP1\ButtonState2=BCF_DrawButton(0,0,TMP1\Tx,TMP1\Ty,2,TMP1\Label$,TMP1\Style)
	Next

	; ----------------------------------------------------------
	; On refais les images du fond des fenêtres
	; ----------------------------------------------------------
	For TMP2.TWindow=Each TWindow
		FreeImage TMP2\BackGround1
		FreeImage TMP2\BackGround2
		
		TMP2\BackGround1=BCF_DrawWindow(0,0,TMP2\Tx,TMP2\Ty,TMP2\Style,TMP2\Icon,TMP2\Label$,0)	; Fenetre active full
		TMP2\BackGround2=BCF_DrawWindow(0,0,TMP2\Tx,TMP2\Ty,TMP2\Style,TMP2\Icon,TMP2\Label$,1) 	; Fenetre non active full
	Next

	; --------------------------------------------------------
	; On refais les images du fond des listbox
	; --------------------------------------------------------
	For TMP3.TListBox = Each TListBox
		FreeImage TMP3\BackGround1
		FreeImage TMP3\BackGround2
		
		TMP3\Background1=BCF_Make3dBarImage(0,0,TMP3\Tx-19,TMP3\Ty,1,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
		TMP3\Background2=BCF_Make3dBarImage(0,0,18,TMP3\Ty,1,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
	Next

	; ------------------------------------------------------
	; On refais les images du fond des slider
	; ------------------------------------------------------
	For TMP4.TSlIder=Each TSlIder
		FreeImage TMP4\BackGround

		If BCF_GuiStyle=1  Then
			TMP4\BackGround=BCF_Draw3dBarBitmap(0,0,TMP4\Tx,TMP4\Ty,2,800)
		EndIf

		If BCF_GuiStyle=2  Then
			TMP4\BackGround=BCF_Draw3dBarBitmap(0,0,TMP4\Tx,TMP4\Ty,2,801)
		EndIf

		If BCF_GuiStyle=3  Then
			TMP4\BackGround=BCF_Draw3dBarBitmap(0,0,TMP4\Tx,TMP4\Ty,2,802)
		EndIf
	Next

	; ------------------------------------------------------------
	; On refais les images du fond des checkbox
	; ------------------------------------------------------------
	For TMP5.TCheckbox=Each TCheckbox
		FreeImage TMP5\BackGround1
		FreeImage TMP5\BackGround2
		
		TMP5\BackGround1=BCF_DrawCheckbox(0,0,TMP5\Tx,TMP5\Ty,0,TMP5\Label$)
		TMP5\BackGround2=BCF_DrawCheckbox(0,0,TMP5\Tx,TMP5\Ty,1,TMP5\Label$)
	Next

	; ---------------------------------------------------------
	; On refais les images du fond des images
	; ---------------------------------------------------------
	For TMP6.TImage=Each TImage
		FreeImage TMP6\BackGround
		
		TMP6\BackGround=BCF_Make3dBarImage(0,0,TMP6\Tx,TMP6\Ty,2,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
	Next

	; ------------------------------------------------------
	; On refais les images du fond des icons
	; ------------------------------------------------------
	For TMP7.TIcon = Each TIcon
		FreeImage TMP7\ButtonState1
		FreeImage TMP7\ButtonState2
		
		TMP7\ButtonState1=BCF_DrawButton(0,0,TMP7\Tx,TMP7\Ty,1,"",TMP7\Style)
		TMP7\ButtonState2=BCF_DrawButton(0,0,TMP7\Tx,TMP7\Ty,2,"",TMP7\Style)
	Next

	; -------------------------------------------------------------------
	; On refais les images du fond des bitmaps button
	; -------------------------------------------------------------------
	For TMP8.TBitmapButton = Each TBitmapButton
		FreeImage TMP8\ButtonState1
		FreeImage TMP8\ButtonState2
		
		TMP8\ButtonState1=BCF_DrawButton(0,0,TMP8\Tx,TMP8\Ty,1,"",TMP8\Style)
		TMP8\ButtonState2=BCF_DrawButton(0,0,TMP8\Tx,TMP8\Ty,2,"",TMP8\Style)
	Next

	; -----------------------------------------------------------
	; On refais les images du fond des scrollbar
	; -----------------------------------------------------------
	For TMP9.TScrollBar =Each TScrollBar
		FreeImage TMP9\BackGround
		
		If BCF_GuiStyle=1  Then
			TMP9\BackGround=BCF_Draw3dBarBitmap(0,0,TMP9\Tx,TMP9\Ty,2,800)
		EndIf

		If BCF_GuiStyle=2  Then
			TMP9\BackGround=BCF_Draw3dBarBitmap(0,0,TMP9\Tx,TMP9\Ty,2,801)
		EndIf

		If BCF_GuiStyle=3  Then
			TMP9\BackGround=BCF_Draw3dBarBitmap(0,0,TMP9\Tx,TMP9\Ty,2,802)
		EndIf	
	Next

	; --------------------------------------------------------
	; On refais les images du fond des frames
	; --------------------------------------------------------
	For TMP10.TFrame = Each TFrame
		FreeImage TMP10\BackGround
		
		TMP10\BackGround=BCF_DrawFrame(0,0,TMP10\Tx,TMP10\Ty,TMP10\Label$,TMP10\Style)
	Next

	; -------------------------------------------------------------
	; On refais les images du fond des combobox
	; -------------------------------------------------------------
	For TMP11.TComboBox = Each TComboBox
		FreeImage TMP11\BackGround1
		FreeImage TMP11\BackGround2
		
		TMP11\BackGround1=BCF_Make3dBarImage(0,0,TMP11\Tx-19,TMP11\Ty,1,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
		TMP11\BackGround2=BCF_Make3dBarImage(0,0,18,18,1,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
	Next 
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ------------------------------------
; Innitialisation des window
; ------------------------------------
Function BCF_CreateWindow(Px,Py,Tx,Ty,Style,Icon,Label$,Reduc=True,Close=True,Locked=False)
	BCF.TWindow=New TWindow
	BCF\Id=Handle(BCF)
	BCF\Px=Px
	BCF\Py=Py
	BCF\Tx=Tx
	BCF\Ty=Ty
	BCF\Style=Style
	BCF\Label$=Label$
	BCF\Active = False
	BCF\State = 0
	BCF\WIdthDragX% = Tx
	
	BCF\Visible = True
	BCF\Locked = Locked
	
	; ------------------------------------------------------------
	; Test pour la fenetre virtuel et choix de l'icone
	; ------------------------------------------------------------
	If Style=99 Then
		Insert BCF Before First TWindow
		BCF_HaVirtualParent = Handle(BCF)
	Else
		Select Icon
		Case 1
			BCF\Icon=BCF_ReadRawImage(50)
		Case 2
			BCF\Icon=BCF_ReadRawImage(51)
		Case 3
			BCF\Icon=BCF_ReadRawImage(52)
		Case 4
			BCF\Icon=BCF_ReadRawImage(53)
		Case 5
			BCF\Icon=BCF_ReadRawImage(54)
		Case 6
			BCF\Icon=BCF_ReadRawImage(55)
		Default
			BCF\Icon=BCF_ReadRawImage(55)
		End Select
		
		; ---------------------------------------------
		; Creation du bouton de fermeture
		; ---------------------------------------------
		If Close Then 
				TmpPx=21
				BCF\Id_close = BCF_CreateButton(BCF\Id,Tx-TmpPx,-21,14,14,"",99)
		EndIf
		
		; --------------------------------------------
		; Creation du bouton de reduction
		; --------------------------------------------
 		If Reduc Then 
			TmpPx=39
			If Close=False Then TmpPx=21
				BCF\Id_reduction = BCF_CreateButton(BCF\Id,Tx-TmpPx,-21,14,14,"",98)
			EndIf

		; --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		; Definition de la longueur de la barre de titre pour ne pas deplacer la fenetre quand il y a les gadgets de fermeture et d'iconisation
		; --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		BCF\WIdthDragX%=BCF\WIdthDragX% - TmpPx
	EndIf

	BCF\BackGround1=BCF_DrawWindow(0,0,BCF\Tx,BCF\Ty,Style,BCF\Icon,BCF\Label$,0) ; Fenetre normale full
	BCF\BackGround2=BCF_DrawWindow(0,0,BCF\Tx,BCF\Ty,Style,BCF\Icon,BCF\Label$,1) ; Fenetre non active full
	
	BCF_ActiveLastWindow()
	Return BCF\Id
End Function

; -----------------------------
;-Gestion des fenêtres
; -----------------------------
Function BCF_RenderWindow()
	If BCF_Menu Or BCF_MenuPopUpActif Then
		If BCF_MouseRelease_L Then
			If BCF_MouseOnMenu()=False Then
				If BCF_Move3DMouse( 0,0,GraphicsWidth(),21) =False Then					
						BCF_CloseAllMenu()
						BCF_MenuActif = False
						BCF_MenuPopUpActif = False
				EndIf
			EndIf
		EndIf

		If BCF_MenuSelection Then
			BCF_CloseAllMenu()
			BCF_MenuSelection=False
			BCF_MenuActif = False
			BCF_MenuPopUpActif = False
		EndIf
	EndIf
	
	; ----------------------------------------------------------
	; Sommes nous sur une ComboBox ouverte
	; ----------------------------------------------------------
	If BCF_ComboVisible Then
		ActiveComboBox = BCF_TestActiveComboBox()
	Else
		ActiveComboBox=False
	EndIf

	;  ---------------------------------------------------------------------------------------------------------------
	; Si nous ne sommes pas en mode deplacement ou avec un ComboBox d'ouverture
	; ----------------------------------------------------------------------------------------------------------------
	If BCF_WindowMove = False  And ActiveComboBox=False And BCF_MenuActif=False Then
		; ----------------------------------------------
		; Sommes nous sur la fenetre actif
		; ----------------------------------------------
		ActiveWindow = BCF_TestActiveWindow()
		
		BCF.TWindow = Last TWindow

		; ----------------------------
		; Pour chaque fenetre
		; ----------------------------
		While BCF<>Null
			; ---------------------------------------------------------------------------------
			; Definition de la taille y de la fenetre en fonction de son State
			; ---------------------------------------------------------------------------------
			If BCF\State=0 Then
				Tmpheight=BCF\Ty
			Else
				Tmpheight=20
			EndIf

			; ----------------------------------------------------------------------------------------------------------------------
			; La souris est elle bien dans la zone de la fenetre en cours et la souris a elle ete clique
			;  ---------------------------------------------------------------------------------------------------------------------
			If BCF_Move3DMouse( BCF\Px , BCF\Py , BCF\Tx , Tmpheight,True) And BCF_MouseClicked_L And BCF\Visible = True Then		; And BCF\Visible = True fixed by customer
				; -------------------------------------------
				; On perds le focus de l'input box
				; -------------------------------------------
				If BCF_InputBoxFocus Then
					BCF_KillInputBoxFocus
				EndIf
				
				; -------------------------------------------------------------
				; On capture le click s'il n'y a pas de requester
				; -------------------------------------------------------------
				If BCF_Requester=False Then
					; ----------------------------------------------------------------
					; Ce n'est pas la fenetre Active qui recoit le focus
					; ----------------------------------------------------------------
					If ActiveWindow=False Then
						; ---------------------------------------------------------------------------------------------------
						; On place la fenetre en fin du type si elle est differente de la fenetre virtuel
						; ---------------------------------------------------------------------------------------------------
						If BCF\Id<>BCF_IdVirtualParent Then
							Insert BCF After Last TWindow
						EndIf
						
						; ----------------------------------
						; Elle passe fenetre Active
						; ----------------------------------
						BCF_TestNoActiveWindow()
						BCF_WindowActive = Handle( BCF )
						BCF\Active = True
						ActiveWindow = True
					EndIf
				EndIf

				; -------------------------------------------------------------------
				; On click sur la barre de titre de la fenetre Active  ?
				; -------------------------------------------------------------------
				If BCF_Move3DMouse( BCF\Px , BCF\Py , BCF\WIdthDragX% , 20,True) And BCF\Active=True  And BCF\Id<>BCF_IdVirtualParent And BCF\Locked=False Then
					; ----------------------------------------------
					; On passe ne mode deplacement
					; ----------------------------------------------
					BCF_WindowMove = True
					BCF\DragX = MouseX() - BCF\Px

					BCF\DragY = MouseY() - BCF\Py
				End If
			Else
				If BCF_WindowActive <> Handle( BCF )  And BCF_Requester=False Then
					BCF\Active = False
				EndIf
			EndIf

			BCF=Before BCF
		Wend
	EndIf

	; --------------------------------------------
	; Gestion d'affichage des fenêtres
	; --------------------------------------------
	For BCF.TWindow =Each TWindow
			
			If (BCF\Visible)
				; ------------------------------------------------
				; Si fenetre en deplacement et Active
				; ------------------------------------------------
				If  BCF_WindowMove And BCF\Active = True Then
					BCF\Px = BCF_MouseX- BCF\DragX 
		     		BCF\Py = BCF_MouseY- BCF\DragY	
					TempStyle=BCF\Style
	
					If BCF\Py<22 And BCF_Menu Then BCF\Py=22
				EndIf
	
				; -------------------------------------------------------
				; Affichage de la fenetre et de ses enfants
				; -------------------------------------------------------
				; Si fenetre normale deplié
				If BCF\State=0 Then
					DrawImage BCF\BackGround1,BCF\Px,BCF\Py
					
					Color BCF_GetRed(Bcf_Color08),BCF_GetGreen(Bcf_Color08), BCF_GetBlue(Bcf_Color08)
				EndIf
	
				; Si fenetre normale replié
				If BCF\State=1 Then
					DrawImageRect BCF\BackGround1,BCF\Px,BCF\Py,0,0,BCF\Tx+1,21
	
					Color BCF_GetRed(Bcf_Color08),BCF_GetGreen(Bcf_Color08), BCF_GetBlue(Bcf_Color08)
				EndIf
	
				; Si pas active et si pas fenetre virtuel
				If BCF\Active = False  And BCF\Id <> BCF_IdVirtualParent  Then 
					DrawImageRect BCF\BackGround2,BCF\Px,BCF\Py,0,0,BCF\Tx+1,21
				EndIf
				
				; ---------------------------
				; Gestion du viewport
				; ---------------------------
				Viewport BCF\Px, BCF\Py,BCF\Tx, BCF\Ty
				
				; ------------------------------------------
				; Affichage du label de la fenêtre
				; ------------------------------------------
				Text BCF\Px+23,BCF\Py+3,BCF\Label$
	
				; -------------------------------------
				; Reinitialisation du viewport
				; -------------------------------------
				Viewport 0, 0,GraphicsWidth(), GraphicsHeight()
	
				; -----------------------------------------------------------------------------------------
				; Affichage des frames et des boutons et des tooltip en premier
				; -----------------------------------------------------------------------------------------
				BCF_RenderFrame(Handle(BCF))
				BCF_RenderButton(Handle(BCF))
				BCF_RenderButtonToolTip(Handle(BCF))
				
				; --------------------------------------------------------------------------------------
				; si la fenetre n'est pas reduite on affiche les controles enfant
				; --------------------------------------------------------------------------------------
				If BCF\State=0 Then
					hparent=Handle(BCF ) 
					BCF_RenderViewPort( hParent )
					
					BCF_RenderBitmapButton( hParent)
					
					BCF_RenderIcon( hParent)
					BCF_RenderSlider(hParent)
					BCF_RenderCheckbox(hParent)
					BCF_RenderInputBox( hParent)
					BCF_RenderLabelText(hParent)
					BCF_RenderGauge(hParent)
					BCF_RenderImage(hParent)
				
					BCF_RenderScrollBar(hParent)
					BCF_RenderComboBox(hParent)
					BCF_RenderListBox(hParent)

					; ------------------------------------------------------------------------------------------
					; Les tooltips en derniers sinon il s'affichent derriere les gadgets
					; ------------------------------------------------------------------------------------------
					BCF_RenderButtonToolTip(hparent)
					BCF_RenderBitmapButtonToolTip(hParent)
				EndIf
			
				; -------------------------------------------
				; Gestion du bouton de reduction 
				; -------------------------------------------
				If BCF_TestButton(BCF\Id_reduction) Then
					If BCF\State=0 Then
						BCF\State=1
					Else
						BCF\State=0
					EndIf
				EndIf
				
				; -----------------------------------------------------------------------------------------------------------
				; Gestion du bouton de  fermeture si nous ne somme pas sur une requester
				; -----------------------------------------------------------------------------------------------------------
				If BCF_TestButton(BCF\Id_close) And BCF_Requester=False Then
					BCF_KillWindow(BCF\Id)
				EndIf
			EndIf
	Next	

	; ---------------------------------------------------------------------------------------------
	; Affichage des menu et des infotext apres tout les autres gadgets
	; ---------------------------------------------------------------------------------------------
	BCF_RenderPopUpMenu()
	BCF_RenderTitleMenu()
	BCF_RenderInfoText()
End Function

; -------------------------------
; Affichage des fenêtres
; -------------------------------
Function BCF_DrawWindow(Px,Py,Tx,Ty,Style,Icon,Label$,State)
	Px=0 : Py=0

	; -------------------------------------------------
	; Si fenetre reduite alors petite image
	; -------------------------------------------------
	If  State<>0 Then
		BCF_TmpImage=CreateImage(Tx+1,22)
	Else 
		BCF_TmpImage=CreateImage(Tx+1,Ty+1)
	EndIf
	
	SetBuffer ImageBuffer( BCF_TmpImage )
	
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont
	
	; --------------------------------------------
	; La barre de titre si fenetre active
	; --------------------------------------------
	If State=0 Then 
		Select Style
		Case 1 ; Style 3d normal
			BCF_Draw3dBarBitmap(Px,Py,Tx,20,1,2000,BCF_TmpImage)
		Case 2 ; Style Degradé
			BCF_Draw3dBarBitmap(Px,Py,Tx,20,1,2002,BCF_TmpImage)
		Case 3 ; Style Applat
			BCF_Draw3dBarBitmap(Px,Py,Tx,20,1,2004,BCF_TmpImage)		
		End Select
	EndIf

	; ----------------------------------------------
	; La barre de titre si fenetre inactive
	; ----------------------------------------------
	If State=1 Then 
		Select Style
		Case 1 ; Style 3d normal
			BCF_Draw3dBarBitmap(Px,Py,Tx,20,1,2001,BCF_TmpImage)
		Case 2 ; Style Degradé
			BCF_Draw3dBarBitmap(Px,Py,Tx,20,1,2003,BCF_TmpImage)
		Case 3 ; Style Applat
			BCF_Draw3dBarBitmap(Px,Py,Tx,20,1,2005,BCF_TmpImage)
		End Select
	EndIf
	
	; ------------------------------------------
	; Le body de la fenetre et le texte
	; ------------------------------------------
	If Style<99 Then
		; -----------------------------------------------------------------
		; Si la fenetre est reduite on n'affiche pas le body
		; -----------------------------------------------------------------
		If State=0 Then
			BCF_Draw3dBar(Px,Py+21,Tx,Ty-22,1,BCF_GetRed(Bcf_Color09),BCF_GetGreen(Bcf_Color09), BCF_GetBlue(Bcf_Color09))
		EndIf
	
		; ---------------------------
		; Affichage de l'icone
		; ---------------------------
		If Icon<>0 Then 
			DrawImage Icon,Px+3,Py+2
		EndIf 
	EndIf
		
	SetBuffer BackBuffer()
	Return BCF_TmpImage
End Function

; ------------------------------------------------------------------------------------------------------------------------------
; Permet de tester si la souris se trouve sur une fenetre (paramètre de retour = True ou False)
; ------------------------------------------------------------------------------------------------------------------------------
Function BCF_TestActiveWindow()
	bRetour = False

	ActiveWindow.TWindow = Object.TWindow( BCF_WindowActive)
	
	If ActiveWindow <> Null Then
		If ActiveWindow\State=0 Then
			TmpHeight = ActiveWindow\Ty
		Else
			TmpHeight = 20
		EndIf

		If BCF_Move3DMouse( ActiveWindow\Px , ActiveWindow\Py , ActiveWindow\Tx , TmpHeight ) Then
			bRetour = True
		EndIf
		
		If ActiveWindow\Id = BCF_IdVirtualParent Then 
			bRetour = False
		EndIf
	EndIf
	
	Return bRetour
End Function

; -----------------------------------------------------------------------
; Permet de tester il reste une fenetre visible à l'ecran
; -----------------------------------------------------------------------
Function BCF_TestLastWindow()
	Tmp=0
	
	For Test.TWindow = Each TWindow
		Tmp=Tmp+1
	Next

	If   Tmp=0 And BCF_VirtualP = False
		Return True
	EndIf

	If Tmp=1 And BCF_VirtualP = True
		Return True
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------
; Renvoi si une fenetre est inactive ou non (paramètre de retour = True ou False)
; ------------------------------------------------------------------------------------------------------------
Function BCF_TestNoActiveWindow()
	ActiveWindow.TWindow = Object.TWindow( BCF_WindowActive)
	
	If ActiveWindow<>Null
		ActiveWindow\Active = False
	EndIf
End Function

; ---------------------------------------------------------------------------------------------------------
; Renvoi si une fenetre est replié ou non (paramètre de retour = True ou False)
; ---------------------------------------------------------------------------------------------------------
Function BCF_TestWindowsMinimized(Id)
	BCF.TWindow = Object.TWindow(Id)

	If (BCF <> Null) Then
   		Return BCF\state
 	EndIf
End Function

; ---------------------------------------------------------------------------------
; Gestion de la fenetre virtuel pour les controles sans fenetre
; ---------------------------------------------------------------------------------
Function BCF_TestVirtualParent()
	; -----------------------------------------------------------
 	; Si la fenetre virtuelle n'existe pas on la cree
	; -----------------------------------------------------------
	If BCF_VirtualP=False Then
		BCF_IdVirtualParent = BCF_CreateWindow(0,0,GraphicsWidth(),GraphicsHeight(),99,-1,"",False,False)
		BCF_VirtualP = True
	EndIf
	
	Return BCF_IdVirtualParent
End Function

; -----------------------------------------
; Permet de réduire une fenêtre
; -----------------------------------------
Function BCF_MinimizeWindow(Id)
 	BCF.TWindow = Object.TWindow(Id)

	If (BCF <> Null) Then
   		BCF\state=1
 	EndIf
End Function

; ---------------------------------------------
; Permet de d'agrandir une fenêtre
; ---------------------------------------------
Function BCF_MaximizeWindow(Id)
 	BCF.TWindow = Object.TWindow(Id)

	If (BCF <> Null) Then
   		BCF\state=0
 	EndIf
End Function

; ---------------------------------------------------
; Permet de réduire toutes les fenêtres
; ---------------------------------------------------
Function BCF_MinimizeAllWindow()
	For BCF.TWindow = Each TWindow
		BCF\state=1
	Next
End Function

; ---------------------------------------------------
; Permet d'agrandir toutes les fenêtres
; ---------------------------------------------------
Function BCF_MaximizeAllWindow()
	For BCF.TWindow = Each TWindow
		BCF\state=0
	Next
End Function

; ----------------------------------------------------------------
; Fonction pour activer la derniere fenetre affiche
; ----------------------------------------------------------------
Function BCF_ActiveLastWindow()
	; ----------------------------------------
	; On desative toute les fenêtres
	; ----------------------------------------
	For BCF.TWindow =Each TWindow
		BCF\Active=False
	Next
	
	; ----------------------------------------		
	; La dialog est la fenetre active
	; ----------------------------------------
	BCF.TWindow = Last TWindow
	BCF_WindowActive = Handle( BCF )
	BCF\Active = True
End Function

; ----------------------------------------------------------------------------
; Permet d'effacer une fenetre et tout les controles enfant
; ----------------------------------------------------------------------------
Function BCF_KillWindow(Id)
	BCF.TWindow = Object.TWindow(Id)
	If (BCF <> Null) Then
		; ----------------------------------
		; On supprime les enfants
		; ----------------------------------
		BCF_KillFrameChild(BCF\Id)
		BCF_KillButtonChild(BCF\Id)
		BCF_KillBitmapButtonChild(BCF\Id)
		BCF_KillIconChild(BCF\Id)
		BCF_KillSliderChild(BCF\Id)
		BCF_KillCheckboxChild(BCF\Id)
		BCF_KillInputBoxChild(BCF\Id)
		BCF_KillLabelTextChild(BCF\Id)
		BCF_KillGaugeChild( BCF\Id )

		BCF_KillImagechild( IdWin )

		BCF_KillScrollBarChild( BCF\Id )
		BCF_KillListBoxChild(BCF\Id)
		BCF_KillComboBoxChild(BCF\Id)

		BCF_KillViewPortchild( BCF\Id )

		; -----------------------------------------
		; L'icone et les fonds de fenetre
		; -----------------------------------------
		FreeImage BCF\BackGround1
		FreeImage BCF\BackGround2
		FreeImage BCF\Icon
		
		Delete BCF
	EndIf
End Function

; ------------------------------------------------------
; Permet de changer le titre d'une fenetre
; ------------------------------------------------------
Function BCF_ChangeWindowLabel(Id,Label$)
	BCF.TWindow = Object.TWindow(Id)
	If (BCF <> Null) Then
		BCF\Label$=Label$
	EndIf
End Function

; ------------------------------------------------------------
; Permet de changer la position d'une fenetre
; ------------------------------------------------------------
Function BCF_ChangeWindowPosition(Id,Px,Py)
	BCF.TWindow = Object.TWindow(Id)
	If (BCF <> Null) Then
		BCF\Px=Px
		BCF\Py=Py
	EndIf
End Function

; ----------------------------------------------
; Renvoi la position X d'une fenetre
; ----------------------------------------------
Function BCF_GetWindowX(Id)
	BCF.TWindow = Object.TWindow(Id)
	If (BCF <> Null) Then
		Return BCF\Px
	EndIf	
End Function

; ----------------------------------------------
; Renvoi la position Y d'une fenetre
; ----------------------------------------------
Function BCF_GetWindowY(Id)
	BCF.TWindow = Object.TWindow(Id)
	If (BCF <> Null) Then
		Return BCF\Py
	EndIf	
End Function

; ------------------------------------------
; Renvoi la largeur d'une fenetre
; ------------------------------------------
Function BCF_GetWindowWIdth(Id)
	BCF.TWindow = Object.TWindow(Id)
	If (BCF <> Null) Then
		Return BCF\Tx
	EndIf	
End Function

; ------------------------------------------
; Renvoi la hauteur d'une fenetre
; ------------------------------------------
Function BCF_GetWindowHeight(Id)
	BCF.TWindow = Object.TWindow(Id)
	If (BCF <> Null) Then
		Return BCF\Ty
	EndIf	
End Function

; ----------------------------------------
; Permet de locker une fenetre
; ----------------------------------------
Function BCF_LockWindow(Id,LockMode)
	BCF.TWindow = Object.TWindow(Id)
	If (BCF <> Null) Then
		BCF\Locked=LockMode
	EndIf	
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 ;------------------------------------
; Innitialisation des frames
; -----------------------------------
Function BCF_CreateFrame(WinId,Px,Py,Tx,Ty,Label$, Style=1)
	
	BCF.TFrame=New TFrame
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py
	BCF\Tx=Tx
	BCF\Ty=Ty
	BCF\Label$=Label$
	BCF\Style=Style
	
	BCF\Visible = True
	
	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf
	
	; -------------------------------------------
	; Declaration du fond de la frame
	; -------------------------------------------
	BCF\BackGround=BCF_DrawFrame(0,0,BCF\Tx,BCF\Ty,BCF\Label$,BCF\Style)
	
	Return BCF\Id
End Function

; --------------------------------
; Gestion des frames 3D
; --------------------------------
Function BCF_RenderFrame( hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
			
	For BCF.TFrame = Each TFrame
		
		; ----------------------------------------------------------
		; Si le State de la fenetre est 0 (non réduite) 
		; ----------------------------------------------------------
		If BCF\WinId = ParentWindow\Id And ParentWindow\State=0 And BCF\Visible Then
			; ---------------------------------------------------
			; On cherche l'offset X et Y de la fenetre
			; ---------------------------------------------------
			TmpX=BCF\Px+ParentWindow\Px+2   ; 2=Bordure 3D de la gauche de la fenetre
			TmpY=BCF\Py+ParentWindow\Py+23   ; 4=Hauteur differente de 23 pour une raison obscure

			DrawImage BCF\Background,TmpX,TmpY
		EndIf
	Next
End Function

; -----------------------------
; Affichage des frames
; -----------------------------
Function BCF_DrawFrame(Px,Py,Tx,Ty,Label$,Style)
	Px=0 : Py=0
	
	BCF_TmpImage=CreateImage(Tx+1,Ty+1)
	SetBuffer ImageBuffer( BCF_TmpImage )
	
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont

	; ----------------------------------------
	; Affichage du cadre et du texte
	; ----------------------------------------
	Select Style
		Case 1
			Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
			Rect Px,Py+3,Tx,Ty-4,0

			Color BCF_GetRed(Bcf_Color05),BCF_GetGreen(Bcf_Color05), BCF_GetBlue(Bcf_Color05)
			Rect Px+1,Py+4,Tx,Ty-4,0
		Case 2
			BCF_Draw3dBar(Px,Py+4,Tx,Ty-4,1,BCF_GetRed(Bcf_Color09),BCF_GetGreen(Bcf_Color09), BCF_GetBlue(Bcf_Color09))
		Case 3
			BCF_Draw3dBar(Px,Py+4,Tx,Ty-4,2,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
	End Select
	
	If Label$<>"" Then
		Color BCF_GetRed(Bcf_Color09),BCF_GetGreen(Bcf_Color09), BCF_GetBlue(Bcf_Color09)
		Rect Px+5,Py-4,StringWidth(" "+Label$+" "),12,1
		
		BCF_Color(Bcf_Color03)
		Text Px+5,Py-3," "+Label$+" "
	EndIf

	SetBuffer BackBuffer()
	Return BCF_TmpImage
End Function

; -------------------------------------
; Permet d'effacer une frame
; -------------------------------------
Function BCF_KillFrame(Id)
	BCF.TFrame = Object.TFrame(Id)
	If (BCF <> Null)
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\BackGround
		Delete BCF
	EndIf
End Function

; ---------------------------------------------------------
; Supprime toutes les frames d'une fenetre
; ---------------------------------------------------------
Function BCF_KillFrameChild(IdWin)
	For BCF.TFrame = Each TFrame
		If BCF\WinId=IdWin Then
			BCF_KillFrame(BCF\Id)
		EndIf
	Next 
End Function

; ------------------------------------------------------
; Permet de changer le label d'une frame
; ------------------------------------------------------
Function BCF_ChangeFrameLabel(Id,Label$)
	BCF.TFrame = Object.TFrame(Id)
	If (BCF <> Null)
		BCF\Label$=Label$
	EndIf

	BCF_RegenerateBCF()
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ------------------------------------------
;-Permet de définir des boutons
; ------------------------------------------
Function BCF_CreateButton(WinId,Px,Py,Tx,Ty,Label$,Style=2)
	
	BCF.TButton=New TButton
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	
	BCF\Px=Px
	BCF\Py=Py
	BCF\Tx=Tx
	BCF\Ty=Ty
	BCF\ButtonState=1
	BCF\Label$=Label$
	BCF\Click=False
	BCF\Style=Style
	BCF\ToolTip$=""
	
	BCF\Visible = True
	BCF\Enable=True
	
	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	; -------------------------------------------------------------------------------------
	; Declaration des deux bitmaps des états possible des boutons
	; -------------------------------------------------------------------------------------
	BCF\ButtonState1=BCF_DrawButton(0,0,BCF\Tx,BCF\Ty,1,BCF\Label$,BCF\Style)
	BCF\ButtonState2=BCF_DrawButton(0,0,BCF\Tx,BCF\Ty,2,BCF\Label$,BCF\Style)

	; ----------------------------------------
	; Creation des images disable
	; ----------------------------------------
	BCF\ButtonState3=CopyImage(BCF\ButtonState1)
	BCF_CreateDisableControl(BCF\ButtonState3)
	
	Return BCF\Id
End Function

; -----------------------------------------------------
; Permet d'ajouter un tooltip a un bouton
; -----------------------------------------------------
Function BCF_CreateButtonToolTip(Id,ToolTip$)
	BCF.TButton = Object.TButton(Id)
	If (BCF <> Null)
		BCF\ToolTip$=ToolTip$
	EndIf
End Function

; --------------------------------------
;-Gestion et test des boutons
; --------------------------------------
Function BCF_RenderButton( hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	 For BCF.TButton = Each TButton
		; --------------------------------------------------
	 	; Par defaut le bouton n'est pas activé
		; -------------------------------------------------		
	 	If (BCF\WinId = ParentWindow\Id And BCF\Visible)  Then
			BCF\ButtonState=1
			
			; --------------------------------------------------------------------------------------------------------------------------------------------------------
			; On traite le bouton si l'State de la fenetre est 0 (non réduite) ou si c'est les boutons de fermeture et de reduction
			; --------------------------------------------------------------------------------------------------------------------------------------------------------
			If  ParentWindow\State=0  Or  (BCF\Id=ParentWindow\Id_close Or BCF\Id=ParentWindow\Id_reduction)  Then	
				TmpX= BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
				TmpY= BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre
				
				; -------------------------------------------------------------------------------------------------------------
				; Si la fenêtres active et si on a pas deplié une ComboBox et si le gadget est actif
				; -------------------------------------------------------------------------------------------------------------
				If ParentWindow\Active And (BCF_ComboVisible=False And BCF_MenuActif=False) Then					
					If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx+2 , BCF\Ty+2,True )  And  BCF\Enable=True Then				
						If BCF_MouseClicked_L Then
							 BCF\ButtonState=2
						Else 
							If BCF_MouseRelease_L Then
								BCF\ButtonState=3
							Else 
								BCF\ButtonState=1
							EndIf
						EndIf
					EndIf
				EndIf
			
				; ----------------------------------------------------------------------
				; Gestion des images en fonction de l'etat du bouton
				; ----------------------------------------------------------------------
				Select BCF\ButtonState
				Case 1
					If BCF\Enable=True
						DrawImage BCF\ButtonState1,TmpX,TmpY
					Else
						DrawImage BCF\ButtonState3,TmpX,TmpY
					EndIf
				Case 2
					DrawImage BCF\ButtonState2,TmpX,TmpY
				End Select
			EndIf
		EndIf
	Next 
End Function

; -------------------------------
; Affichage des boutons
; -------------------------------
Function BCF_DrawButton(Px,Py,Tx,Ty,State,Label$,Style)
	Px=1 : Py=1
	
	BCF_TmpImage=CreateImage(Tx+3,Ty+3)
	SetBuffer ImageBuffer( BCF_TmpImage )

	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont

	LabelWIdth=StringWidth(Label$)/2
	LabelHeight=StringHeight(Label$)/2
	
	; --------------------------
	; Contour du gadget
	; --------------------------
	If Style=1 Then
		BCF_Draw3dBar(Px-1,Py-1,Tx+3,Ty+3,5,	BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06))
	EndIf
	
	If Style=2 Then
		BCF_DrawGradientBar(Px-1,Py-1,Tx+2,Ty+2,BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06),BCF_GetRed(Bcf_Color05),BCF_GetGreen(Bcf_Color05), BCF_GetBlue(Bcf_Color05),1)
	EndIf

	If Style=3 Then
		BCF_DrawGradientBar(Px-1,Py-1,Tx+2,Ty+2,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02),BCF_GetRed(Bcf_Color04),BCF_GetGreen(Bcf_Color04), BCF_GetBlue(Bcf_Color04),1)
	EndIf
	
	; ------------------
	; State Normal
	; ------------------
	If State=1 Then
		; ----------------------------------------------------
		; Style 1= Bouton Texte normal et applat
		; ----------------------------------------------------
		If Style=1 Then
			BCF_Draw3dBarBitmap(Px,Py,Tx,Ty,1,10,BCF_TmpImage)

			; ------------------------
			; Affichage du texte
			; ------------------------
			BCF_Color(Bcf_Color03)
			Text Px+Tx/2-LabelWIdth,Py+Ty/2-LabelHeight,Label$
		EndIf

		; -------------------------------------------------------
		; Style 2= Bouton Texte normal et dégradé
		; -------------------------------------------------------
		If style=2 Then
			BCF_Draw3dBarBitmap(Px,Py,Tx,Ty,1,12,BCF_TmpImage)

			; ------------------------
			; Affichage du texte
			; ------------------------
			BCF_Color(Bcf_Color03)
			Text Px+Tx/2-LabelWIdth,Py+Ty/2-LabelHeight,Label$
		EndIf

		; ----------------------------------------------------
		; Style 3= Bouton Texte normal et applat
		; ----------------------------------------------------
		If Style=3 Then
			BCF_Draw3dBarBitmap(Px,Py,Tx,Ty,1,14,BCF_TmpImage)

			; ------------------------
			; Affichage du texte
			; ------------------------
			BCF_Color(Bcf_Color03)
			Text Px+Tx/2-LabelWIdth,Py+Ty/2-LabelHeight,Label$
		EndIf

		; ------------------------------------------------------------------
		; Style 94= Bouton Slider normal direction Gauche
		; ------------------------------------------------------------------
		If Style=94 Then
			Return BCF_ReadRawImage(600)
		EndIf 
			
		; ----------------------------------------------------------------
		; Style 95= Bouton Slider normal direction Droite
		; ----------------------------------------------------------------
		If Style=95 Then
			Return BCF_ReadRawImage(500)
		EndIf
		
		; -----------------------------------------------------------------------------
		; Style 96= Bouton Combo et ListBox normal direction Haut
		; -----------------------------------------------------------------------------
		If Style=96 Then
			If BCF_GuiStyle=1  Then
				Return BCF_ReadRawImage(400)
			EndIf

			If BCF_GuiStyle=2  Then
				Return BCF_ReadRawImage(402)
			EndIf

			If BCF_GuiStyle=3  Then
				Return BCF_ReadRawImage(404)
			EndIf
		EndIf
		
		; -----------------------------------------------------------------------------
		; Style 97= Bouton Combo et ListBox normal direction Bas
		; -----------------------------------------------------------------------------
		If Style=97 Then
			If BCF_GuiStyle=1  Then
				Return BCF_ReadRawImage(300)
			EndIf

			If BCF_GuiStyle=2  Then
				Return BCF_ReadRawImage(302)
			EndIf

			If BCF_GuiStyle=3  Then
				Return BCF_ReadRawImage(304)
			EndIf 
		EndIf
		
		; -------------------------------------------------------------------------
		; Style 98= Bouton de d'iconisation normal et applat
		; -------------------------------------------------------------------------
		If Style=98 Then
			If BCF_GuiStyle=1  Then
				Return BCF_ReadRawImage(100)
			EndIf

			If BCF_GuiStyle=2  Then
				Return BCF_ReadRawImage(102)
			EndIf

			If BCF_GuiStyle=3 Then
				Return BCF_ReadRawImage(104)
			EndIf 
		EndIf
		
		; ---------------------------------------------------------------------
		; Style 99= Bouton de fermeture normal et applat
		; ---------------------------------------------------------------------
		If Style=99 Then
			If BCF_GuiStyle=1  Then
				Return BCF_ReadRawImage(200)
			EndIf

			If BCF_GuiStyle=2  Then
				Return BCF_ReadRawImage(202)
			EndIf

			If BCF_GuiStyle=3 Then
				Return BCF_ReadRawImage(204)
			EndIf 
		EndIf
	EndIf
	
	; -------------------
	; State appuyé
	; -------------------
	If State=2 Or State=4 Then
		; ------------------------------------------------------
		; Style 1= Bouton Texte enfoncé et applat
		; ------------------------------------------------------
		If Style=1  Then
			BCF_Draw3dBarBitmap(Px,Py,Tx,Ty,2,11,BCF_TmpImage)

			; ------------------------
			; Affichage du texte
			; ------------------------
			BCF_Color(Bcf_Color03)
			Text Px+Tx/2-LabelWIdth+1,Py+Ty/2-LabelHeight+1,Label$
		EndIf

		; --------------------------------------------------------
		; Style 2= Bouton Texte enfoncé et degradé
		; --------------------------------------------------------
		If style=2 Then
			BCF_Draw3dBarBitmap(Px,Py,Tx,Ty,2,13,BCF_TmpImage)

			; ------------------------
			; Affichage du texte
			; ------------------------
			BCF_Color(Bcf_Color03)
			Text Px+Tx/2-LabelWIdth+1,Py+Ty/2-LabelHeight+1,Label$
		EndIf

		; ------------------------------------------------------
		; Style 3= Bouton Texte enfoncé et applat
		; ------------------------------------------------------
		If Style=3  Then
			BCF_Draw3dBarBitmap(Px,Py,Tx,Ty,2,15,BCF_TmpImage)

			; ------------------------
			; Affichage du texte
			; ------------------------
			BCF_Color(Bcf_Color03)
			Text Px+Tx/2-LabelWIdth+1,Py+Ty/2-LabelHeight+1,Label$
		EndIf

		; -------------------------------------------------------------------
		; Style 94= Bouton Slider enfoncé direction Gauche
		; -------------------------------------------------------------------
		If Style=94 Then
			Return BCF_ReadRawImage(601)
		EndIf 
			
		; -----------------------------------------------------------------
		; Style 95= Bouton Slider enfoncé direction Droite
		; -----------------------------------------------------------------
		If Style=95 Then
			Return BCF_ReadRawImage(501)
		EndIf
		
		; --------------------------------------------------------------------------------
		; Style 96= Bouton Combo et ListBox enfoncé direction Haut
		; --------------------------------------------------------------------------------
		If Style=96 Then
			If BCF_GuiStyle=1  Then
				Return BCF_ReadRawImage(401)
			EndIf

			If BCF_GuiStyle=2  Then
				Return BCF_ReadRawImage(403)
			EndIf

			If BCF_GuiStyle=3 Then
				Return BCF_ReadRawImage(405)
			EndIf
		EndIf
		
		; ------------------------------------------------------------------------------
		; Style 97= Bouton Combo et ListBox enfoncé direction Bas
		; ------------------------------------------------------------------------------
		If Style=97 Then
			If BCF_GuiStyle=1  Then
				Return BCF_ReadRawImage(301)
			EndIf

			If BCF_GuiStyle=2  Then
				Return BCF_ReadRawImage(303)
			EndIf

			If BCF_GuiStyle=3  Then
				Return BCF_ReadRawImage(305)
			EndIf 
		EndIf
		
		; ----------------------------------------------------------------------
		; Style 98= Bouton de d'iconisation enfoncé et applat
		; ----------------------------------------------------------------------
		If Style=98 Then
			If BCF_GuiStyle=1  Then
				Return BCF_ReadRawImage(101)
			EndIf

			If BCF_GuiStyle=2  Then
				Return BCF_ReadRawImage(103)
			EndIf

			If BCF_GuiStyle=3 Then
				Return BCF_ReadRawImage(105)
			EndIf 
		EndIf
		
		; ------------------------------------------------------------------
		; Style 99= Bouton de fermeture enfoncé et applat
		; ------------------------------------------------------------------
		If Style=99 Then
			If BCF_GuiStyle=1  Then
				Return BCF_ReadRawImage(201)
			EndIf

			If BCF_GuiStyle=2  Then
				Return BCF_ReadRawImage(203)
			EndIf

			If BCF_GuiStyle=3 Then
				Return BCF_ReadRawImage(205)
			EndIf 
		EndIf
	EndIf
	
	SetBuffer BackBuffer()
	Return BCF_TmpImage
End Function

; --------------------------------------------------------
; Renvoi l'etat d'un bouton (pressé/normal)
; --------------------------------------------------------
Function BCF_TestButton(Id)
	BCF.TButton = Object.TButton(Id)
	If (BCF <> Null)
		If BCF\ButtonState=3 Or BCF\ButtonState=4 And BCF\Enable=True Then
			Return True	
		Else
			Return False
		EndIf
	EndIf
End Function

; --------------------------------------------------------------------------------------------------------------------------------------------------------------
; Permet de savoir si un bouton est pressé, utile pour les fonction de zoom etc  (paramètre de retour = True ou False)
; --------------------------------------------------------------------------------------------------------------------------------------------------------------
Function BCF_TestButtonPressed(Id)
	BCF.TButton = Object.TButton(Id)
	If (BCF <> Null)
		If BCF\ButtonState=2 And BCF\Enable=True Then
			Return True	
		Else
			Return False
		EndIf
	EndIf
End Function

; -------------------------------------
; Permet d'effacer un bouton
; -------------------------------------
Function BCF_KillButton(Id)
	BCF.TButton = Object.TButton(Id)
	If (BCF <> Null)
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\ButtonState1
		FreeImage BCF\ButtonState2
		
		FreeImage BCF\ButtonState3
		Delete BCF
	EndIf
End Function

; -------------------------------------------------------
; Supprime tout les Boutons d'une fenetre
; -------------------------------------------------------
Function BCF_KillButtonChild(IdWin)
	For BCF.TButton = Each TButton
		If BCF\WinId=IdWin Then
 			BCF_KillButton(BCF\Id)
		EndIf
	Next 
End Function

; ------------------------------------------------------
; Permet de changer le label d'un bouton
; ------------------------------------------------------
Function BCF_ChangeButtonLabel(Id,Label$)
	BCF.TButton = Object.TButton(Id)
	If (BCF <> Null)
		BCF\Label$=Label$
	EndIf

	; -----------------------------
	; On redessine la BCF
	; -----------------------------
	 BCF_RegenerateBCF()
End Function

; ----------------------------------------------------------
; Permet de changer la position d'un bouton
; ----------------------------------------------------------
Function BCF_ChangeButtonPosition(Id,Px,Py)
	BCF.TButton = Object.TButton(Id)
	If (BCF <> Null)
		BCF\Px=Px
		BCF\Py=Py
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; -------------------------------------------------------
; Permet de créer des icones de couleurs
; -------------------------------------------------------
Function BCF_CreateColorIcon(WinId,Px,Py,Tx,Ty,ColNum,Style=1) 
  
 	BCF.TIcon=New TIcon 
 	BCF\Id=Handle(BCF) 
 	BCF\WinId=WinId 
 	BCF\Px=Px 
 	BCF\Py=Py 

 	BCF\Icon=CreateImage(Tx,Ty) 
 	SetBuffer ImageBuffer(BCF\Icon) 
 	BCF_Color(ColNum)     
 	Rect 0,0,Tx,Ty,True 
 	SetBuffer BackBuffer()   
  
 	BCF\Tx=Tx
 	BCF\Ty=Ty
 	BCF\ButtonState=1 
 	BCF\Click=False 
 	BCF\Style=Style 
	
	BCF\Visible = True
  
 	; ------------------------------------ 
 	; Test pour la fenetre virtuel 
 	; ------------------------------------ 
 	If WinId=False Then 
   	BCF\WinId = BCF_TestVirtualParent() 
   	BCF_IdVirtualParent = BCF\WinId 
 	EndIf 

 	; ------------------------------------------------------------------------------------- 
 	; Declaration des deux bitmaps des états possible des boutons 
 	; ------------------------------------------------------------------------------------- 
 	BCF\ButtonState1=BCF_DrawButton(0,0,BCF\Tx,BCF\Ty,1,"",Style) 
 	BCF\ButtonState2=BCF_DrawButton(0,0,BCF\Tx,BCF\Ty,2,"",Style) 
  
 	Return BCF\Id 
End Function

Function BCF_ChangeColorIcon(Id,ColNum) 
	BCF.TIcon = Object.TIcon(Id)
	If (BCF <> Null)
   		SetBuffer ImageBuffer(BCF\Icon) 
   		BCF_Color(ColNum)     
   		Rect 0,0,BCF\Tx,BCF\Ty,True 
  		SetBuffer BackBuffer()       
	EndIf 
End Function 

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ----------------------------------------------------
;-Permet de definir des boutons bitmap
; ----------------------------------------------------
Function BCF_CreateBitmapButton(WinId,Px,Py,Bitmap$,Style=2)
	
	BCF.TBitmapButton=New TBitmapButton
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py
	BCF\Bitmap=LoadImage(Bitmap$)
	BCF\Tx=ImageWidth(BCF\Bitmap)+1
	BCF\Ty=ImageHeight(BCF\Bitmap)+1
	BCF\ButtonState=1
	BCF\Click=False
	BCF\Style=Style
	BCF\ToolTip$=""
	
	BCF\Visible = True
	BCF\Enable = True
	
	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	; -------------------------------------------------------------------------------------
	; Declaration des deux bitmaps des états possible des boutons
	; -------------------------------------------------------------------------------------
	BCF\ButtonState1=BCF_DrawButton(0,0,BCF\Tx,BCF\Ty,1,"",Style)
	BCF\ButtonState2=BCF_DrawButton(0,0,BCF\Tx,BCF\Ty,2,"",Style)

	; ----------------------------------------
	; Creation des images disable
	; ----------------------------------------
	BCF\BitmapDisable=CopyImage(BCF\Bitmap)
	BCF_CreateDisableControl(BCF\BitmapDisable)
	
	Return BCF\Id
End Function

; ---------------------------------------------------------------
; Permet d'ajouter un tooltip a un bouton bitmap
; ---------------------------------------------------------------
Function BCF_CreateBitmapButtonToolTip(Id,ToolTip$)
	BCF.TBitmapButton = Object.TBitmapButton (Id)
	If (BCF <> Null)
		BCF\ToolTip$=ToolTip$
	EndIf
End Function

; -----------------------------------------------
;-Gestion et test des buttons bitmap
; -----------------------------------------------
Function BCF_RenderBitmapButton( hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	 For BCF.TBitmapButton = Each TBitmapButton
		; --------------------------------------------------
	 	; Par defaut le bouton n'est pas activé
		; -------------------------------------------------
	 	If (BCF\WinId = ParentWindow\Id And BCF\Visible) Then

			BCF\ButtonState=1
			
			; ------------------------------------------------------------------------------------------------------------------------------------------------------
			; On traite le bouton si l'State de la fenetre est 0 (non réduite) ou si c'est les boutons de fermeture et de reduction
			; ------------------------------------------------------------------------------------------------------------------------------------------------------
			If  ParentWindow\State=0  Or  (BCF\Id=ParentWindow\Id_close Or BCF\Id=ParentWindow\Id_reduction) Then
			
				TmpX= BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
				TmpY= BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre

				; -----------------------------------------------------------------------------
				; Si la fenêtres active et si on a pas deplié une ComboBox
				; -----------------------------------------------------------------------------
				If ParentWindow\Active And (BCF_ComboVisible=False And BCF_MenuActif=False) Then
					If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx , BCF\Ty,True )  And  BCF\Enable=True  Then  
						If BCF_MouseClicked_L Then
							 BCF\ButtonState=2
						Else 
							If BCF_MouseRelease_L Then
								BCF\ButtonState=3
							Else 
								BCF\ButtonState=1
							EndIf
						EndIf				
					EndIf
				EndIf
				
				; ----------------------------------------------------------------------
				; Gestion des images en fonction de l'etat du bouton
				; ----------------------------------------------------------------------
				Select BCF\ButtonState
				Case 1
					If BCF\Style>=1 Then 
						DrawImage BCF\ButtonState1,TmpX,TmpY
					EndIf

					If BCF\Enable=True
						DrawImage BCF\Bitmap,TmpX+2,TmpY+2
					Else
						DrawImage BCF\BitmapDisable,TmpX+2,TmpY+2
					EndIf
				Case 2
					If BCF\Style>=1 Then 
						DrawImage BCF\ButtonState2,TmpX,TmpY
					EndIf
					
					DrawImage BCF\Bitmap,TmpX+3,TmpY+3
				End Select
			EndIf			
		EndIf
	Next 
End Function

; ------------------------------------------------------------------
; Renvoi l'etat d'un bitmap button (pressé/normal)
; ------------------------------------------------------------------
Function BCF_TestBitmapButton(Id)
	BCF.TBitmapButton = Object.TBitmapButton (Id)
	If (BCF <> Null)
		If BCF\ButtonState=3 Or BCF\ButtonState=4 Then
			Return True	
		Else
			Return False
		EndIf
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
; Permet de savoir si un bouton bitmap est pressé, utile pour les fonction de zoom etc  (paramètre de retour = True ou False)
; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Function BCF_TestBitmapButtonPressed(Id)
	BCF.TBitmapButton = Object.TBitmapButton (Id)
	If (BCF <> Null)
		If BCF\ButtonState=2 Then
			Return True	
		Else
			Return False
		EndIf
	EndIf
End Function

; ----------------------------------------------
; Permet d'effacer un bitmap button
; ----------------------------------------------
Function BCF_KillBitmapButton(Id)
	BCF.TBitmapButton = Object.TBitmapButton (Id)
	If (BCF <> Null)
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\ButtonState1
		FreeImage BCF\ButtonState2
		
		FreeImage BCF\Bitmap
		FreeImage BCF\BitmapDisable
		Delete BCF
	EndIf
End Function

; ------------------------------------------------------------------
; Supprime toutes les bitmap button d'une fenetre
; ------------------------------------------------------------------
Function BCF_KillBitmapButtonChild(IdWin)
	For BCF.TBitmapButton = Each TBitmapButton
		If BCF\WinId=IdWin Then
			BCF_KillBitmapButton(BCF\Id)
		EndIf
	Next 
End Function

; --------------------------------------------------------------------
; Permet de changer la position d'un bouton bitmap
; --------------------------------------------------------------------
Function BCF_ChangeBitmapButtonPosition(Id,Px,Py)
	BCF.TBitmapButton = Object.TBitmapButton (Id)
	If (BCF <> Null)
		BCF\Px=Px
		BCF\Py=Py
	EndIf
End Function

; ----------------------------------------------------------------
; Permet de changer l'image d'un bouton bitmap
; -----------------------------------------------------------------
Function BCF_ChangeBitmapButtonBitmap(Id,Bitmap$)
	BCF.TBitmapButton = Object.TBitmapButton (Id)
	If (BCF <> Null)
		BCF\Bitmap=LoadImage(Bitmap$)
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; -------------------------------------------------------------------------------------------------
;-Permet de definir des icones (Style 1=Avec cadre, Style 0= Sans cadre)
; -------------------------------------------------------------------------------------------------
Function BCF_CreateIcon(WinId,Px,Py,Icon,Style=1)
	
	BCF.TIcon=New TIcon
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py
	BCF\Icon=BCF_ReadRawImage(Icon)
	BCF\Tx=ImageWidth(BCF\Icon)
	BCF\Ty=ImageHeight(BCF\Icon)
	BCF\ButtonState=1
	BCF\Click=False
	BCF\Style=Style
	
	BCF\Visible = True
	BCF\Enable = True
	
	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	; -------------------------------------------------------------------------------------
	; Declaration des deux bitmaps des états possible des boutons
	; -------------------------------------------------------------------------------------
	BCF\ButtonState1=BCF_DrawButton(0,0,BCF\Tx,BCF\Ty,1,"",Style)
	BCF\ButtonState2=BCF_DrawButton(0,0,BCF\Tx,BCF\Ty,2,"",Style)

	; ----------------------------------------
	; Creation des images disable
	; ----------------------------------------
	BCF\IconDisable=CopyImage(BCF\Icon)
	BCF_CreateDisableControl(BCF\IconDisable)
	
	Return BCF\Id
End Function

; ------------------------------------
;-Gestion et test des icones
; ------------------------------------
Function BCF_RenderIcon( hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	 For BCF.TIcon = Each TIcon
	
		; --------------------------------------------------
	 	; Par defaut le bouton n'est pas activé
		; -------------------------------------------------		
	 	If (BCF\WinId = ParentWindow\Id And BCF\Visible) Then
			BCF\ButtonState=1
			
			; ------------------------------------------------------------------------------------------------------------------------------------------------------
			; On traite le bouton si l'State de la fenetre est 0 (non réduite) ou si c'est les boutons de fermeture et de reduction
			; ------------------------------------------------------------------------------------------------------------------------------------------------------
			If  ParentWindow\State=0  Or  (BCF\Id=ParentWindow\Id_close Or BCF\Id=ParentWindow\Id_reduction) Then
			
				TmpX= BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
				TmpY= BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre

				; -----------------------------------------------------------------------------
				; Si la fenêtres active et si on a pas deplié une ComboBox
				; -----------------------------------------------------------------------------
				If ParentWindow\Active And (BCF_ComboVisible=False And BCF_MenuActif=False) Then
					If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx , BCF\Ty,True) And  BCF\Enable=True Then 
						If BCF_MouseClicked_L Then
							 BCF\ButtonState=2
						Else 
							If BCF_MouseRelease_L Then
								BCF\ButtonState=3
							Else 
								BCF\ButtonState=1
							EndIf
						EndIf				
					EndIf
				EndIf

				; ---------------------------
				; Affichage du bouton
				; ---------------------------
				Select BCF\ButtonState
				Case 1
					If BCF\Style>=1 Then 
						DrawImage BCF\ButtonState1,TmpX,TmpY
					EndIf

					If BCF\Enable=True
						DrawImage BCF\Icon,TmpX+1,TmpY+1
					Else
						DrawImage BCF\IconDisable,TmpX+1,TmpY+1
					EndIf
				Case 2
					If BCF\Style>=1 Then 
						DrawImage BCF\ButtonState2,TmpX,TmpY
					EndIf
					
					DrawImage BCF\Icon,TmpX+2,TmpY+2
				End Select
			EndIf			
		EndIf
	Next 
End Function

; -------------------------------------------------------
; Renvoi l'etat d'une icon (pressé/normal)
; -------------------------------------------------------
Function BCF_TestIcon(Id)
	BCF.TIcon = Object.TIcon (Id)
	If (BCF <> Null)
		If BCF\ButtonState=3 Or BCF\ButtonState=4Then
			Return True	
		Else
			Return False
		EndIf
	EndIf
End Function

; -----------------------------------
; Permet d'effacer une icon
; -----------------------------------
Function BCF_KillIcon(Id)
	BCF.TIcon = Object.TIcon (Id)
	If (BCF <> Null)
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\ButtonState1
		FreeImage BCF\ButtonState2
		
		FreeImage BCF\Icon
		FreeImage BCF\IconDisable
		
		Delete BCF
	EndIf
End Function

; -------------------------------------------------------
; Supprime toutes les Icons d'une fenetre
; -------------------------------------------------------
Function BCF_KillIconChild(IdWin)
	For BCF.TIcon = Each TIcon
		If BCF\WinId=IdWin Then
			BCF_KillIcon(BCF\Id)
		EndIf
	Next 
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ---------------------------------------
;-Permet de définir les slIders
; ---------------------------------------
Function BCF_CreateSlIder(WinId,Px,Py,Tx,Ty,Min#,Max#,Value#,Integer,Label$,Style,Red,Green,Blue)
	BCF.TSlIder=New TSlIder
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py
	BCF\Tx=Tx+2
	BCF\Ty=Ty
	BCF\State=0
	BCF\Min# = Min#
	BCF\Max# = Max#
	BCF\Value#=Value#
	BCF\Integer=Integer
	BCF\Flag = 0
	BCF\Label$=Label$
	BCF\Style=Style
	BCF\Red = Red
	BCF\Green = Green
	BCF\Blue = Blue
	
	BCF\Visible = True
	BCF\Enable = True

	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	; --------------------------------------
	; Creation de l'image du fond
	; --------------------------------------
	If BCF_GuiStyle=1  Then
		BCF\BackGround=BCF_Draw3dBarBitmap(0,0,BCF\Tx,BCF\Ty,2,800)
	EndIf

	If BCF_GuiStyle=2  Then
		BCF\BackGround=BCF_Draw3dBarBitmap(0,0,BCF\Tx,BCF\Ty,2,801)
	EndIf

	If BCF_GuiStyle=3  Then
		BCF\BackGround=BCF_Draw3dBarBitmap(0,0,BCF\Tx,BCF\Ty,2,802)
	EndIf

	BCF\BackGroundDisable=BCF_CreateDisableControl(BCF\BackGround,False)

	Return BCF\Id
End Function

; -----------------------------------------
; Rafraichissement des slIders
; -----------------------------------------	
Function BCF_RenderSlider(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	For BCF.TSlIder = Each TSlIder
	 	If (BCF\WinId = ParentWindow\Id  And BCF\Visible) Then
		
			TmpX=BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
			TmpY=BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre
			
			If BCF_Move3DMouse( TmpX+3 , TmpY, BCF\Tx-3, BCF\Ty) Then
				If BCF_Move3DMouse( TmpX+3 , TmpY, BCF\Tx-4, BCF\Ty,True) And ParentWindow\Active And BCF_MouseClicked_L And (BCF_ComboVisible=False And BCF_MenuActif=False) And BCF\Enable=True Then
					; --------------------------------------------------------------------------------------------------
					; Changement du BCF\State pour eviter le refraichissement de BCF\Flag
					; --------------------------------------------------------------------------------------------------
					BCF\State=1	
					Mouse_X=MouseX()-3	; -3= bordure gauche du slIder(2) +1 pour securité	
					
					BCF\Flag=Mouse_X-TmpX
					BCF\Value#=BCF\Min#+(Mouse_X-TmpX)* (BCF\Max#-BCF\Min#) / (BCF\Tx-4)	; -4 = 2x2 fois la bordure gauche et droite

					If BCF\Value#<BCF\Min# Then BCF\Value#= BCF\Min#
					If BCF\Value#>BCF\Max# Then BCF\Value#=BCF\Max#
					
					; ----------------------------------------------------------------------
					; Pour caler le curseur sur le slIder plus simplement
					; ----------------------------------------------------------------------
					Mouse_X=MouseX()
					MoveMouse Mouse_X,TmpY+(BCF\Ty/2)
				EndIf
			Else
				; -----------------------------------------------------------------------------------------------------------------------------------------
				; Sert a initialiser le curseur du slIder (translation Min & Max => Pixel) avant d'avoir fais le premier click
				; -----------------------------------------------------------------------------------------------------------------------------------------
				If BCF\State=0 Then
					BCF\Flag=(BCF\Value#-BCF\Min#)*(BCF\Tx-4) / (BCF\Max#-BCF\Min#)
					BCF\State=1
				EndIf
			EndIf

		DrawImage BCF\BackGround,TmpX ,TmpY
		BCF_DrawSlIder(TmpX ,TmpY, BCF\Tx, BCF\Ty, BCF\Flag, BCF\Value#, BCF\Label$, BCF\Integer, BCF\Style,BCF\Red, BCF\Green, BCF\Blue)

		; --------------------------------------------------------------------
		; Si le gadget est desactive on affiche l'image grisé
		; --------------------------------------------------------------------
		If BCF\Enable=False  Then 
			DrawImage BCF\BackGroundDisable,TmpX,TmpY
		EndIf 
	EndIf
	
	Next
End Function

; -------------------------------------------
; Fonction pour tracer les slIders
; -------------------------------------------
Function BCF_DrawSlIder(Px,Py,Tx,Ty,Flag,Value#,Label$,Integer,Style,Red,Green,Blue)
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont

	; -------------------------------------
	; On Trace la barre du slIder
	; -------------------------------------
	Select Style
	Case 1
		BCF_Draw3dBar(Px+2 ,Py+2,Flag,Ty -4,1,Red,Green,Blue) 
	Case 2
		BCF_Draw3dBar(Px+2 ,Py+2,Flag,Ty -4,1,Red,Green,Blue)
	Case 3
		BCF_Draw3dBar(Px+2 ,Py+2,Flag,Ty -4,1,Red,Green,Blue) 
	End Select

	; ---------------------------
	; Gestion du viewport
	; ---------------------------
	Viewport Px+2 ,Py,Tx -4, Ty 
	
	; ---------------------------------------
	; Si le slIder est de type entier
	; ---------------------------------------
	BCF_Color(Bcf_Color03)
	
	If Integer=True Then
		Text Px+Tx/2,Py+Ty/2,Label$+" : "+Int(Value#),True,True 	
	Else
		Text Px+Tx/2,Py+Ty/2,Label$+" : "+Value#,True,True 		
	EndIf

	; -------------------------------------
	; Reinitialisation du viewport
	; -------------------------------------
	Viewport 0, 0,GraphicsWidth(), GraphicsHeight()
End Function

; --------------------------------------------------
; Renvoi la valeur en cours d'un slIder
; --------------------------------------------------
Function BCF_TestSlIder#(Id)
	BCF.TSlIder = Object.TSlIder (Id)
	If (BCF <> Null)
		If BCF\Integer
			Return Int(BCF\Value#)
		Else
			Return BCF\Value#
		EndIf
	EndIf
End Function

; ------------------------------------
; Permet d'effacer un SlIder
; ------------------------------------
Function BCF_KillSlIder(Id)
	BCF.TSlIder = Object.TSlIder (Id)
	If (BCF <> Null)
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\BackGround
		FreeImage BCF\BackGroundDisable
		Delete BCF
	EndIf
End Function

; ----------------------------------------------------
; Supprime tout les SlIder d'une fenetre
; ----------------------------------------------------
Function BCF_KillSliderChild(IdWin)
	For BCF.TSlIder = Each TSlIder
		If BCF\WinId=IdWin Then
			BCF_KillSlIder( BCF\Id )
		EndIf
	Next 
End Function

; ------------------------------------------------------
; Permet de changer le label d'un slider
; ------------------------------------------------------
Function BCF_ChangeSliderLabel(Id,Label$)
	BCF.TSlIder = Object.TSlIder (Id)
	If (BCF <> Null)
		BCF\Label$=Label$
	EndIf
End Function

; ------------------------------------------------------
; Permet de changer la valeur d'un slider
; ------------------------------------------------------
Function BCF_ChangeSliderValue(Id,Value#)
	BCF.TSlIder = Object.TSlIder (Id)
	If (BCF <> Null)
		BCF\value#=value#
		BCF\Flag = (BCF\Value#-BCF\Min#)*(BCF\Tx-4) / (BCF\Max#-BCF\Min#)
	EndIf
End Function

; ------------------------------------------------------------
; Permet de changer la valeur max d'un slider
; ------------------------------------------------------------
Function BCF_ChangeSliderMax(Id,Max#)
	BCF.TSlIder = Object.TSlIder (Id)
	If (BCF <> Null)
		BCF\Max#=Max#
		BCF\Flag = (BCF\Value#-BCF\Min#)*(BCF\Tx-4) / (BCF\Max#-BCF\Min#)
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; -------------------------------------------
;-Permet de definir des scrollbar
; -------------------------------------------
Function BCF_CreateScrollBar( WinId,Px,Py,Tx,Ty,Min#,Max#,Pas#,Label$,DrawLabel,Red=-1,Green=-1,Blue=-1 )

	BCF.TScrollBar = New TScrollBar
	
	BCF\Id 			= Handle(BCF)
	BCF\WinId 	= WinId
	BCF\Px			= Px
	BCF\Py			= Py
	BCF\Tx			= Tx+2
	BCF\Ty			= Ty
	BCF\Label$ 	= Label$
	BCF\DrawLabel = DrawLabel
	
	BCF\Pas#		= Pas#
	BCF\Min#		= Min#
	BCF\Max			= Max#
	
	BCF\Indexscroll = 0
	BCF\Slider_X 		= 0
	BCF\Slider_move = False

	BCF\Red= Red
	BCF\Green= Green
	BCF\Blue= Blue
	
	BCF\Visible = True
	BCF\Enable = True

	; -----------------------------------
	; Calcul du nombre de pas
	; -----------------------------------
	BCF\NbPas =  (Max#-Min#) / BCF\Pas#

	; ------------------------------------------------------------------------------
	; Calcul de la taille du bouton de l'ascenseur
	; ------------------------------------------------------------------------------
	If BCF\Nbpas>1 Then
			BCF\Slider_w = (BCF\Tx - 4) /  BCF\Nbpas
	Else
			If BCF\Nbpas= 1 Then
				BCF\Slider_w = (BCF\Tx - 4) / 2
		EndIf
	EndIf
	
	; ------------------------------------------------------------------------------
	; Limitation minimale de la taille du bouton de l'ascenseur
	; ------------------------------------------------------------------------------
	If BCF\Slider_W#<10 Then BCF\Slider_W#=10

	; ---------------------------------------------------------------------------------------------------------
	; Calcul de la longueur du pas en fonction de la taille du bouton de  l'ascenseur
	; ---------------------------------------------------------------------------------------------------------
	If  BCF\Nbpas>0 Then
			BCF\Longueur_pas# = ((BCF\Tx - 4 - BCF\Slider_w# ) / (BCF\Nbpas)) 
		Else
			BCF\Longueur_pas#=BCF\Tx - 4
	EndIf

	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If winId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	; --------------------------------------
	; Creation de l'image du fond
	; --------------------------------------
	If BCF_GuiStyle=1  Then
		BCF\BackGround=BCF_Draw3dBarBitmap(0,0,BCF\Tx,BCF\Ty,2,800)
	EndIf

	If BCF_GuiStyle=2  Then
		BCF\BackGround=BCF_Draw3dBarBitmap(0,0,BCF\Tx,BCF\Ty,2,801)
	EndIf

	If BCF_GuiStyle=3  Then
		BCF\BackGround=BCF_Draw3dBarBitmap(0,0,BCF\Tx,BCF\Ty,2,802)
	EndIf

	BCF\BackGroundDisable=BCF_CreateDisableControl(BCF\BackGround,False)

	Return BCF\Id
End Function

; --------------------------------------------
; Rafraichissement des Scrollbar
; --------------------------------------------
Function BCF_RenderScrollBar(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)

	For BCF.TScrollBar = Each TScrollBar

		nTime = 130
		
		Mouse_CLickedRight=False
		Mouse_ClickedLeft=False
		
		If (BCF\WinId = ParentWindow\Id And BCF\Visible)  Then
			TmpX=BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
			TmpY=BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre

			; ------------------------------------------------
			; On memorise la position de la liste
			; ------------------------------------------------
			BCF\ScrollTx = TmpX
			BCF\ScrollTy = TmpY

			DrawImage BCF\Background,TmpX,TmpY
		
			; --------------------------------
			; Doit on afficher le label
			; --------------------------------
			If BCF\DrawLabel Then
				BCF_DrawScrollBarText(TmpX,TmpY,BCF\tx,BCF\ty,BCF\label$,BCF\Value#,BCF\Pas#)
			EndIf

			; -------------------------------------------
			; Affichage du bouton Ascenceur
			; -------------------------------------------
			TmpAX= BCF\Px + ParentWindow\Px+2 + BCF\Slider_X +2
			TmpAY= BCF\Py  + ParentWindow\Py+2  + BCF\ty + 3

			; ----------------------------------------------
			; Colorisation du scroller si besoin
			; ----------------------------------------------
			If BCF\Red=-1 Then
				BCF_Draw3dBar( TmpAX , TmpAY, BCF\Slider_w# , BCF\Ty-4,1,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
			Else
				BCF_Draw3dBar( TmpAX , TmpAY, BCF\Slider_w# , BCF\Ty-4,1,BCF\Red,BCF\Green,BCF\Blue)
			EndIf
	
			; ----------------------
			; Si fenetre active
			; ----------------------
			;If ParentWindow\active And (BCF_ComboVisible=False And BCF_MenuActif=False) Then
			If BCF_ComboVisible=False And BCF_MenuActif=False Then
				; ------------------------------------
				; Somme nous sur le scroll
				; -------------------------------------
				If ParentWindow\active Then 
					If BCF_Move3DMouse( TmpX+2 , TmpY , BCF\tx-4 , BCF\Ty)   And BCF\Enable=True  Then
						bMouseScroll=True
					Else
						bMouseScroll=False
					EndIf

					If BCF_Move3DMouse( TmpX+2 , TmpY , BCF\tx-4 , BCF\Ty,True) And MouseDown(1)  And BCF\Enable=True   Then
						If MouseX() < TmpX + BCF\SlIder_X# + BCF\SlIder_W#  Then
							nTime = 0
							Mouse_ClickedLeft=True
						Else
							Mouse_ClickedLeft=False
						EndIf

						If MouseX()> TmpX + BCF\SlIder_X#+BCF\SlIder_W# Then
							nTime = 0
							Mouse_ClickedRight=True
						Else
							Mouse_CLickedRight=False
						EndIf			
					EndIf

					; -------------------------------------------------------
					; Actionne t- on l'ascenseur avec la souris
					; -------------------------------------------------------
					If  BCF_Move3DMouse( TmpAX , TmpAY, BCF\Slider_w# , BCF\Ty-4,True ) And BCF_MouseClicked_L   And BCF\Enable=True  Then
						If BCF\Slider_move=False Then
							BCF\Slider_move = True
							BCF\Drag_x = MouseX() - BCF\Slider_x
						EndIf
					Else
						If  BCF_MouseClicked_L = False Then 
							BCF\SlIder_move = False
						EndIf
					EndIf
				EndIf 

				; -------------------------------------------------------------------------
				; Gestion du deplacement de l'ascenseur par la souris
				; -------------------------------------------------------------------------
				If BCF\Slider_move Then
					; ------------------------------
					; Calcul de la postion Y
					; ------------------------------
					TmpSlider_x# = BCF\Slider_x#
					BCF\Slider_x#  = BCF_MouseX- BCF\Drag_X
					
					; -------------------------------------------------------------------------
					; Limitation de la zone de scroll du bouton d'ascenseur
					; -------------------------------------------------------------------------
					If BCF\SlIder_x#<0 Then
						BCF\SlIder_x# = TmpSlIder_x#
					EndIf

					If BCF\SlIder_x# >BCF\Nbpas *  BCF\longueur_pas# Then
						BCF\SlIder_x#= TmpSlIder_x#
					EndIf
						
					; ------------------------------------
					; Calcul de la valeur d'index
					; ------------------------------------
					BCF\Indexscroll= BCF\Slider_x / BCF\longueur_pas#	
					
					; ----------------------------------------------------------------------
					; Pour caler le curseur sur le slIder plus simplement
					; ----------------------------------------------------------------------
					Mouse_X=MouseX()
					MoveMouse Mouse_X,TmpAY+(BCF\Ty/2)
				Else
					; ----------------------------------------------------
					; Gestion par les gadgets HAUT et BAS
					; ----------------------------------------------------
					BCF\Slider_X# = BCF\Indexscroll * BCF\Longueur_pas#

					If BCF_MouseZSpeed>0 Then
						nTime = 0
						bWheelLeft=True
					Else
						bWheelLeft=False
					EndIf

					If BCF_MouseZSpeed<0 Then
						nTime = 0
						bWheelRight=True
					Else
						bWheelRight=False
					EndIf
					
					; ----------------
					; Gadget Left
					; ----------------
					If  (bWheelLeft And bMouseScroll) Or Mouse_ClickedLeft Then
						If BCF\Indexscroll>=1 And ( BCF_TimeOut(BCF_ListTimer) Or bWhellLeft) Then
							BCF_ListTimer=BCF_SetTimer(nTime )
							BCF\Indexscroll=BCF\Indexscroll-1
						EndIf
					EndIf

					; ------------------
					; Gadget Right
					; ------------------
					If  (bWheelRight And bMouseScroll) Or Mouse_ClickedRight Then
						If BCF\Indexscroll+1=< BCF\NbPas# And (BCF_TimeOut(BCF_ListTimer) Or bWheelRight) Then
							BCF_ListTimer=BCF_SetTimer( nTime )
							BCF\Indexscroll=BCF\Indexscroll+1
						EndIf
					EndIf
				EndIf

				BCF\Value# = BCF\Min# + BCF\Indexscroll * BCF\Pas#
		EndIf
		
		; --------------------------------------------------------------------
		; Si le gadget est desactive on affiche l'image grisé
		; --------------------------------------------------------------------
		If BCF\Enable=False  Then 
			DrawImage BCF\BackGroundDisable,TmpX,TmpY
		EndIf
		
		End If
	Next
End Function

; -----------------------------------------------------------
; Permet d'afficher les labels d'une ScrollBar
; -----------------------------------------------------------
Function BCF_DrawScrollBarText(Px,Py,Tx,Ty, label$ ,value# , pas#  )
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont
	
	; -----------------------------------------------
	; Sommes nous avec un pas entier
	; -----------------------------------------------
	Tmp = pas# Mod 2
	
	If Tmp<>0 Then
		Integer=True
	Else
		Integer=False
	EndIf

	; ---------------------------
	; Gestion du viewport
	; ---------------------------
	Viewport Px+2 ,Py,Tx -4, Ty 
	
	; ------------------------
	; Affichage du texte
	; ------------------------
	BCF_Color(Bcf_Color03)
	
	If Integer=True Then
		Text Px+Tx/2,Py+Ty/2,Label$+" : "+Int(Value#),True,True 	
	Else
		Text Px+Tx/2,Py+Ty/2,Label$+" : "+Value#,True,True 		
	EndIf

	; -------------------------------------
	; Reinitialisation du viewport
	; -------------------------------------
	Viewport 0, 0,GraphicsWidth(), GraphicsHeight()
End Function

; ------------------------------------------------------------
; Permet de renvoyer la valeur d'une ScrollBar
; ------------------------------------------------------------
Function BCF_TestScrollBar#( id )
	BCF.TScrollBar = Object.TScrollBar (Id)
	If (BCF <> Null)
		Return BCF\Value#
	EndIf
End Function

; ------------------------------------------
; Permet d'effacer une ScrollBar
; ------------------------------------------
Function BCF_KillScrollBar( Id )
	BCF.TScrollBar = Object.TScrollBar (Id)
	If (BCF <> Null)
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\Background
		FreeImage BCF\BackGroundDisable
		Delete BCF
	EndIf
End Function

; ------------------------------------------------------------
; Supprime toutes les ScrollBar d'une fenetre
; ------------------------------------------------------------
Function BCF_KillScrollBarChild( IdWin )
		For BCF.TScrollBar =Each TScrollBar
			If BCF\WinId = IdWin Then
				BCF_KillScrollBar( BCF\Id )
			EndIf
		Next
End Function

; -----------------------------------------------------------
; Permet de changer le label d'une ScrollBar
; -----------------------------------------------------------
Function BCF_ChangeScrollBarLabel(Id,Label$)
	BCF.TScrollBar = Object.TScrollBar (Id)
	If (BCF <> Null)
		BCF\Label$=Label$
	EndIf
End Function

; ------------------------------------------------------------
; Permet de changer la valeur d'une ScrollBar
; ------------------------------------------------------------
Function BCF_ChangeScrollBarValue( id , value# )
	BCF.TScrollBar = Object.TScrollBar (Id)
	If (BCF <> Null)
		If value#<BCF\Min# Then value#=BCF\Min#
		If value#>BCF\Max# Then value#=BCF\Max
		; ------------------------------------------------------
		; Calcul de la nouvelle position du slider
		; ------------------------------------------------------
		BCF\value#=value#
		BCF\indexScroll = (BCF\value#-BCF\Min#) / BCF\Pas#
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ------------------------------------------
;-Permet de definir des inputbox
; ------------------------------------------
Function BCF_CreateInputBox(WinId,Px,Py,Label$,MaxLen,CapsOnly,Type_Input=1,MaxVisChar=-1)
		
	BCF.TInputBox=New TInputBox
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py

	If ((MaxVisChar > 0) And (MaxVisChar < MaxLen))
		BCF\MaxVisChar = MaxVisChar
		BCF\Tx=MaxVisChar*8+5
	Else
		BCF\MaxVisChar = MaxLen
		BCF\Tx=MaxLen*8+5
	EndIf

	BCF\Ty=16
	BCF\Label$=Label$
	BCF\MaxLen=MaxLen
	BCF\CapsOnly=CapsOnly
	BCF\Actif = False
	BCF\Type_Input = Type_Input
	
	BCF\Visible = True

	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf
	
	Return BCF\Id
End Function

; -------------------------------------------
; Rafraichissement des inputbox
; -------------------------------------------
Function BCF_RenderInputBox( hWindow )
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	 For BCF.TInputBox = Each TInputBox
	 	; ----------------------------------------------------------
		; Si le State de la fenetre est 0 (non réduite) 
		; ----------------------------------------------------------
	 	If (BCF\WinId = ParentWindow\Id And ParentWindow\State=0 And BCF\Visible) Then
			; ---------------------------------------------------
			; On cherche l'offset X et Y de la fenetre
			; ---------------------------------------------------
			TmpX=BCF\Px+ParentWindow\Px+2   ; 2=Bordure 3D de la gauche de la fenetre
			TmpY=BCF\Py+ParentWindow\Py+23 ; 20=Hauteur de la barre de titre
			
			; -------------------------------
			; Affichage de l'InputBox
			; -------------------------------
			BCF_DrawInputBox(TmpX,TmpY,BCF\Label$,BCF\MaxLen,BCF\MaxVisChar)
		
			; --------------------------
			; On teste l'InputBox
			; --------------------------
			If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx+7 , BCF\Ty,True ) And BCF_MouseClicked_L  And (BCF_Requester=False Or (BCF_Requester And ParentWindow\Active=True) )  And (BCF_ComboVisible=False And BCF_MenuActif=False) Then
				If ParentWindow\Active  Then
					; -------------------------------------------
					; On perds le focus de l'input box
					; -------------------------------------------
					If BCF_InputBoxFocus Then
						BCF_KillInputBoxFocus
					EndIf
				
					FlushKeys
				
					If (BCF_LastFocusID <> BCF\Id)
						BCF_InputBoxTextPos = 0
						BCF_LastFocusID = BCF\Id
					EndIf

					BCF_InputBoxCursorPos = ((BCF_MouseClicked_X - TmpX) / 8) + BCF_InputBoxTextPos
					If (BCF_InputBoxCursorPos > Len(BCF\Label$)) Then BCF_InputBoxCursorPos = Len(BCF\Label$)
					
					BCF\Actif=True
					BCF\Label$=BCF_InputBox$(TmpX,TmpY,BCF\Label$,BCF\MaxLen,BCF\CapsOnly,BCF\Type_Input,BCF\MaxVisChar)
					BCF_InputBoxFocus=True
				EndIf
			Else If BCF\actif=True Then
				BCF\Label$=BCF_InputBox$(TmpX,TmpY,BCF\Label$,BCF\MaxLen,BCF\CapsOnly,BCF\Type_Input,BCF\MaxVisChar)
			EndIf
		EndIf
	Next
End Function

; ------------------------------------------------
; Fonction pour afficher des InputBox
; ------------------------------------------------
Function BCF_DrawInputBox(Px,Py,Label$,MaxLen,MaxVisChar)
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InputBoxFont
	
	; -------------------------------------
	; Taille X et Y de la ImputBox
	; -------------------------------------
	Tx=MaxVisChar*8+12 : Ty=16
	
	; ----------------------------
	; Affichage du contour
	; ----------------------------
	BCF_Draw3dBar(Px,Py,Tx,Ty,2,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01),BCF_GetBlue(Bcf_Color01))
	
	; ------------------------
	; Affichage du texte
	; ------------------------
	BCF_Color(Bcf_Color03)
	Text Px+2,Py+2,Left$(Label$+"",MaxVisChar),False,False
End Function

; ---------------------------------------------------------
; Fonction qui permet de gérer les inputbox
; ---------------------------------------------------------
Function BCF_InputBox$(Px,Py,Label$,MaxLen,CapsOnly,Type_Input, MaxVisChar)
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InputBoxFont
		
	; -----------------------------
	; Caracteres autorisés
	; -----------------------------
	Select Type_Input
		Case 1 ; Alphanumerique
			v$="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,;:!.&é'(-è_çà)=@-+?/%*$[]\ "
		Case 2 ; Entier
			v$="0123456789--"
		Case 3 ; Flottant
			v$="0123456789.--"
	End Select
	
	; -------------------------------------------------------------------------------
	; Taille du label et definition du curseur a la fin de la chaine
	; -------------------------------------------------------------------------------
	LabelLenght=Len(Label$)	
	
	; -------------------------------------
	; Taille X et Y de la ImputBox
	; -------------------------------------
	Tx=MaxVisChar*8+12 : Ty=16
		
	; -----------------------------------------------
	; Affichage du contour et du curseur
	; -----------------------------------------------
	BCF_Draw3dBar(Px,Py,Tx,Ty,2,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02),BCF_GetBlue(Bcf_Color02))

	; ------------------------
	; Affichage du texte
	; ------------------------
	BCF_Color(Bcf_Color03)		
	Text Px+2,Py+2,Mid$(label$, BCF_InputBoxTextPos+1, MaxVisChar)

	; ---------------
	; Le curseur
	; ---------------
	BCF_CursorPos = (BCF_InputBoxCursorPos - BCF_InputBoxTextPos)
	
	If BCF_CursorPos<MaxVisChar+1 Then
		BCF_Draw3dBar((Px+2)+8*BCF_CursorPos,Py+1,2,Ty-3,1,Sin(MilliSecs()),150,50)
	EndIf

	; ----------------------------------------------
	; Recuparation de la touche frappé
	; ----------------------------------------------
	key=GetKey()

	; ----------------------------------------------------------------
	; Si le caractère fais parti des caracteres permis
	; ----------------------------------------------------------------
	If key>=Asc("a") And key<=Asc("z") And CapsOnly Then key=key-32						
	AvailChar=(Instr(v$,Chr$(key),1)>0)								
	
	; -------------------------------------------------------------------------------------------------------------------
	; Si le caractere est disponible et si on na pas depasse la longueur max de l'inputbox
	; -------------------------------------------------------------------------------------------------------------------
	If AvailChar And LabelLenght<MaxLen Then											
		Label$=Left(Label$,BCF_InputBoxCursorPos)+Chr(key)+Mid(Label$,BCF_InputBoxCursorPos+1)				
		LabelLenght=LabelLenght+1
		BCF_InputBoxCursorPos=BCF_InputBoxCursorPos+1

		If (BCF_InputBoxCursorPos > MaxVisChar)
			BCF_Delta = BCF_InputBoxCursorPos - MaxVisChar
			If (BCF_InputBoxTextPos < BCF_Delta) Then BCF_InputBoxTextPos = BCF_Delta
		EndIf
	Else
		; ---------------------------
		; Touche BackSpace
		; ---------------------------	
		If KeyDown(14)  And BCF_InputBoxCursorPos>0 And BCF_TimeOut(BCF_InputBoxTimer) Then 
			BCF_InputBoxTimer=BCF_SetTimer( 150 )
			Label$=Left(Label$,BCF_InputBoxCursorPos-1)+Mid(Label$,BCF_InputBoxCursorPos+1)
			LabelLenght=LabelLenght-1
			BCF_InputBoxCursorPos=BCF_InputBoxCursorPos-1
			If ((BCF_InputBoxCursorPos = 0) Or (BCF_CursorPos = 0))
				If (BCF_InputBoxTextPos > 0) Then BCF_InputBoxTextPos = BCF_InputBoxTextPos -1
			EndIf
		EndIf

		; --------------------
		; Touche Delete
		; --------------------
		If KeyDown(211) And BCF_InputBoxCursorPos<LabelLenght And BCF_TimeOut(BCF_InputBoxTimer) Then 
			BCF_InputBoxTimer=BCF_SetTimer( 150 )
			Label$=Left(Label$,BCF_InputBoxCursorPos)+Mid(Label$,BCF_InputBoxCursorPos+2)
			LabelLenght=LabelLenght-1			
		EndIf 
			
		; ----------------------------------
		; Touche direction gauche
		; ----------------------------------
		If KeyDown(203) And BCF_InputBoxCursorPos>0 And BCF_TimeOut(BCF_InputBoxTimer) Then 
			BCF_InputBoxTimer=BCF_SetTimer( 150 )
			BCF_InputBoxCursorPos=BCF_InputBoxCursorPos-1
			If ((BCF_InputBoxCursorPos = 0) Or (BCF_CursorPos = 0))
				If (BCF_InputBoxTextPos > 0) Then BCF_InputBoxTextPos = BCF_InputBoxTextPos -1
			EndIf
		EndIf
			
		; --------------------------------
		; Touche direction droite
		; --------------------------------			
		If KeyDown(205)  And BCF_InputBoxCursorPos<LabelLenght And BCF_TimeOut(BCF_InputBoxTimer) Then 
			BCF_InputBoxTimer=BCF_SetTimer( 150 )
			BCF_InputBoxCursorPos=BCF_InputBoxCursorPos+1

			If (BCF_InputBoxCursorPos > MaxVisChar)
				BCF_Delta = BCF_InputBoxCursorPos - MaxVisChar
				If (BCF_InputBoxTextPos < BCF_Delta) Then BCF_InputBoxTextPos = BCF_Delta
			EndIf
		EndIf	
		
		; -------------------
		; Touche home
		; -------------------		
		If KeyDown(199) And BCF_InputBoxCursorPos>0 And BCF_TimeOut(BCF_InputBoxTimer) Then 
			BCF_InputBoxTimer=BCF_SetTimer( 150 )
			BCF_InputBoxCursorPos = 0
			BCF_InputBoxTextPos = 0
		EndIf
		
		; ----------------
		; Touche end
		; ----------------		
		If KeyDown(207)  And BCF_InputBoxCursorPos<LabelLenght And BCF_TimeOut(BCF_InputBoxTimer) Then 
			BCF_InputBoxTimer=BCF_SetTimer( 150 )
			BCF_InputBoxCursorPos=LabelLenght

			If (BCF_InputBoxCursorPos > MaxVisChar)
				BCF_Delta = BCF_InputBoxCursorPos - MaxVisChar
				BCF_InputBoxTextPos = BCF_Delta
			EndIf
		EndIf	
		
		
		; ------------------
		; Touche enter
		; ------------------
		If Key=13 Then
			BCF_KillInputBoxFocus()
		EndIf
	EndIf
		
	; -----------------------------------
	; VIdage du tampon clavier
	; -----------------------------------
	FlushKeys

	Return label$
	
End Function

; ----------------------------------------
; Renvoi le label d'un InputBox
; ----------------------------------------
Function BCF_TestInputBox$(Id)
	BCF.TInputBox= Object.TInputBox (Id)
	If (BCF <> Null)
		Return BCF\Label$
	EndIf
End Function

; ----------------------------------------
; Permet d'effacer un inputbox
; ----------------------------------------
Function BCF_KillInputBox(Id)
	BCF.TInputBox= Object.TInputBox (Id)
	If (BCF <> Null)
		Delete BCF
	EndIf
End Function

; ---------------------------------------------------------
; Permet de changer le focus d'un InputBox
; ---------------------------------------------------------
Function BCF_KillInputBoxFocus()
	For BCF.TInputBox = Each TInputBox
		If BCF\actif = True Then 
			BCF\actif=False
			BCF_InputBoxFocus=False
			Return True
		EndIf
	Next	
End Function

; -----------------------------------------------------------
; Supprime toutes les InputBox d'une fenetre
; -----------------------------------------------------------
Function BCF_KillInputBoxChild(IdWin)
	For BCF.TInputBox = Each TInputBox
		If BCF\WinId=IdWin Then
			Delete BCF
		EndIf
	Next 
End Function

; --------------------------------------------------------
; Permet de changer le label d'un inputbox
; --------------------------------------------------------
Function BCF_ChangeInputBoxLabel(Id,Label$)
	BCF.TInputBox= Object.TInputBox (Id)
	If (BCF <> Null)
		; -------------------------------------------------------------------------------------------------------
		; On cherche si le nouveau label est compatible avec le MaxLen de l'InputBox
		; -------------------------------------------------------------------------------------------------------
		If Len(Label$)>BCF\MaxLen Then
			TmpLabel$=Left(Label$,BCF\MaxLen)
		Else
			TmpLabel$=Label$
		EndIf
			BCF\Label$=TmpLabel$
		BCF_InputBoxTextPos = 0
		BCF_LastFocusId = -1
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; -------------------------------------------
;-Permet de définir les Checkbox
; -------------------------------------------
Function BCF_CreateCheckbox(WinId,Px,Py,State,Label$)
		
	BCF.TCheckbox=New TCheckbox
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py
	BCF\Label$=Label$
	BCF\Tx=StringWidth(BCF\Label$)+18
	BCF\Ty=15
	BCF\State=State
	
	BCF\Visible = True
	BCF\Enable= True

	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	; --------------------------------------------
	; Creation des images du gadget
	; --------------------------------------------
	BCF\BackGround1=BCF_DrawCheckbox(0,0,BCF\Tx,BCF\Ty,0,BCF\Label$)
	BCF\BackGround2=BCF_DrawCheckbox(0,0,BCF\Tx,BCF\Ty,1,BCF\Label$)

	; ----------------------------------------
	; Creation des images disable
	; ----------------------------------------
	BCF\BackGround3=CopyImage(BCF\BackGround1)
	BCF_CreateDisableControl(BCF\BackGround3)

	BCF\BackGround4=CopyImage(BCF\BackGround2)
	BCF_CreateDisableControl(BCF\BackGround4)
	
	Return BCF\Id
End Function

; ----------------------------------------
;-Gestion et test des checkbox
; ----------------------------------------
Function BCF_RenderCheckbox(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	For BCF.TCheckbox = Each TCheckbox
		; ----------------------------------------------------------
		; Si le State de la fenetre est 0 (non réduite) 
		; ----------------------------------------------------------
	 	If (BCF\WinId = ParentWindow\Id And ParentWindow\State=0 And BCF\Visible) Then
			TmpX=BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
			TmpY=BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre

			If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx , BCF\Ty ,True) And ParentWindow\Active And (BCF_ComboVisible=False And BCF_MenuActif=False)   Then
				If BCF_MouseRealClick_L  And  BCF\Enable=True Then
					BCF\State=BCF_Switch(BCF\State)
				EndIf
			EndIf	

			; -------------------------------------------------------------------------
			; Gestion des images en fonction de l'etat du checkbox
			; -------------------------------------------------------------------------
			If BCF\State=0 Then
				If BCF\Enable=True
					DrawImage BCF\BackGround1,TmpX,TmpY
				Else
					DrawImage BCF\BackGround3,TmpX,TmpY
				EndIf
			Else
				If BCF\Enable=True
					DrawImage BCF\BackGround2,TmpX,TmpY
				Else
					DrawImage BCF\BackGround4,TmpX,TmpY
				EndIf
			EndIf
		EndIf
	Next
End Function

; ---------------------------------------------
; Fonction pour tracer le Checkbox
; ---------------------------------------------
Function BCF_DrawCheckbox(Px,Py,Tx,Ty,State,Label$)
	Px=0 : Py=0
	
	BCF_TmpImage=CreateImage(Tx+1,Ty+1)
	SetBuffer ImageBuffer( BCF_TmpImage )
	
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont

	Select BCF_GuiStyle
	Case 1
		BCF_Draw3dBarBitmap(Px,Py,15,15,4,23,BCF_TmpImage)
	Case 2
		BCF_Draw3dBarBitmap(Px,Py,15,15,4,25,BCF_TmpImage)
	Case 3
		BCF_Draw3dBarBitmap(Px,Py,15,15,4,27,BCF_TmpImage)
	End Select

	If State=1 Then
		Select BCF_GuiStyle
		Case 1
			BCF_Draw3dBarBitmap(Px,Py,15,15,4,22,BCF_TmpImage)
		Case 2
			BCF_Draw3dBarBitmap(Px,Py,15,15,4,24,BCF_TmpImage)
		Case 3
			BCF_Draw3dBarBitmap(Px,Py,15,15,4,26,BCF_TmpImage)
		End Select
	EndIf
					
	BCF_Color(Bcf_Color03)
	Text Px+20,Py+Ty/2,Label$,False,True
	
	SetBuffer BackBuffer()
	Return BCF_TmpImage
End Function

; --------------------------------------------------------------
; Renvoi l'State d'un checkbox (activé/non activé)
; --------------------------------------------------------------
Function BCF_TestCheckbox(Id)
	BCF.TCheckbox = Object.TCheckbox (Id)
	If (BCF <> Null)
		Return BCF\State
	EndIf
End Function

; ----------------------------------------
; Permet d'effacer un checkbox
; ----------------------------------------
Function BCF_KillCheckbox(Id)
	BCF.TCheckbox = Object.TCheckbox (Id)
	If (BCF <> Null)
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\BackGround1
		FreeImage BCF\BackGround2

		FreeImage BCF\BackGround3
		FreeImage BCF\BackGround4
		Delete BCF
	EndIf
End Function

; ---------------------------------------------------------
; Supprime tout les CheckBox d'une fenetre
; ---------------------------------------------------------
Function BCF_KillCheckboxChild(IdWin)
	For BCF.TCheckbox = Each TCheckbox
		If BCF\WinId=IdWin Then
			BCF_KillCheckbox(BCF\Id)
		EndIf
	Next 
End Function

; ---------------------------------------------------------
; Permet de changer le label d'un checkbox
; ---------------------------------------------------------
Function BCF_ChangeCheckboxLabel(Id,Label$)
	BCF.TCheckbox = Object.TCheckbox (Id)
	If (BCF <> Null)
		BCF\Label$=Label$
		BCF\Tx=StringWidth(BCF\Label$)+18
	EndIf

	; -----------------------------
	; On redessine la BCF
	; -----------------------------
	 BCF_RegenerateBCF()
End Function

; ------------------------------------------------------
; Permet de changer l'State d'un checkbox
; ------------------------------------------------------
Function BCF_ChangeCheckboxState(Id,State)
	BCF.TCheckbox = Object.TCheckbox (Id)
	If (BCF <> Null)
		BCF\State=State
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ---------------------------------------
; Innitialisation des LabelText
; ---------------------------------------
Function BCF_CreateLabelText(WinId,Px,Py,Label$,Align=1,Style=1,Red=255,Green=255,Blue=255)
	
	BCF.TTextLabel=New TTextLabel
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py
	BCF\Label$=Label$
	BCF\Align=Align
	BCF\Style=Style
	BCF\Red=Red
	BCF\Green=Green
	BCF\Blue=Blue
	
	BCF\Visible = True

	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf
	
	Return BCF\Id
End Function

; -------------------------------
; Gestion des LabelText
; -------------------------------
Function BCF_RenderLabelText(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
			
	For BCF.TTextLabel = Each TTextLabel
		; ----------------------------------------------------------
		; Si le State de la fenetre est 0 (non réduite) 
		; ----------------------------------------------------------
		If (BCF\WinId = ParentWindow\Id And ParentWindow\State=0 And BCF\Visible) Then
			; ---------------------------------------------------
			; On cherche l'offset X et Y de la fenetre
			; ---------------------------------------------------
			TmpX=BCF\Px+ParentWindow\Px+2   ; 2=Bordure 3D de la gauche de la fenetre
			TmpY=BCF\Py+ParentWindow\Py+4   ; 4=Hauteur differente de 23 pour une raison obscure

			BCF_DrawLabelText(TmpX,TmpY,BCF\Label$,BCF\Align,BCF\Style,BCF\Red,BCF\Green,BCF\Blue)
		EndIf
	Next
End Function

; --------------------------------------------------
; Fonction pour afficher des LabelText
; --------------------------------------------------
Function BCF_DrawLabelText(Px,Py,Label$,Align,Style,Red,Green,Blue)
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont
	
	FontSize=StringHeight(Label$)+1
	LineChar=0
	Label$=Label$
		
	For i= 1 To Len(Label$)+1
		Char$=Mid$(Label$,i,1)
		
		; ------------------------------------
		; Detection des separateurs
		; ------------------------------------
		If Char$="|" Or i=Len(Label$)+1 Then
			LineChar=LineChar+1
			WriteIn=1
		Else
			LabelString$=LabelString$+Char$
			WriteIn=0
		EndIf
		
		; -----------------------------------
		; Selection de l'alignement
		; -----------------------------------
		Select Align
		Case 1
			Center=False
		Case 2
			Center=True
		End Select

		; ------------------------
		; Affichage du texte
		; ------------------------
		If WriteIn=1  Then
			Select Style
			Case 1 ; Style Normal
				Color Red,Green,Blue
				Text Px,Py+LineChar*FontSize,LabelString$,Center,False
			Case 2 ; Style Ombré
				BCF_Color(Bcf_Color00)
				Text Px+1,(Py+1)+LineChar*FontSize,LabelString$,Center,False
				
				Color Red,Green,Blue
				Text Px,Py+LineChar*FontSize,LabelString$,Center,False
			End Select
			
			LabelString$=""
		End If
	Next 
End Function

; -----------------------------------------
; Permet d'effacer un TextLabel
; -----------------------------------------
Function BCF_KillLabelText(Id)
	BCF.TTextLabel = Object.TTextLabel (Id)
	If (BCF <> Null)
		Delete BCF
	EndIf
End Function

; ---------------------------------------------------------
; Supprime tout les LabelText d'une fenetre
; ---------------------------------------------------------
Function BCF_KillLabelTextChild(IdWin)
	For BCF.TTextLabel = Each TTextLabel
		If BCF\WinId=IdWin Then
			BCF_KillLabelText(BCF\Id)
		EndIf
	Next 
End Function

; --------------------------------------------
; Recupere le texte d'un label text
; --------------------------------------------
Function BCF_GetLabelTextLabel$(Id)
 	BCF.TTextLabel = Object.TTextLabel (Id)
 	If (BCF <> Null)
   		Return BCF\Label$
 	EndIf
End Function

; -----------------------------------------------------------
; Permet de changer le label d"un TextLabel
; -----------------------------------------------------------
Function BCF_ChangeLabelTextLabel(Id,Label$)
	BCF.TTextLabel = Object.TTextLabel (Id)
	If (BCF <> Null)
		BCF\Label$=Label$
	EndIf
End Function

; -----------------------------------------------------------------
; Permet de changer l'alignement d'un TextLabel
; -----------------------------------------------------------------
Function BCF_ChangeLabelTextAlign(Id,Align)
	BCF.TTextLabel = Object.TTextLabel (Id)
	If (BCF <> Null)
		BCF\Align=Align
	EndIf
End Function

; ---------------------------------------------------------
; Permet de changer le style d'un LabelText
; ---------------------------------------------------------
Function BCF_ChangeLabelTextStyle(Id,Style)
	BCF.TTextLabel = Object.TTextLabel (Id)
	If (BCF <> Null)
		BCF\Style=Style
	EndIf
End Function

; --------------------------------------------------------------
; Permet de changer la position d'un LabelText
; --------------------------------------------------------------
Function BCF_ChangeLabelTextPosition(Id,Px,Py)
	BCF.TTextLabel = Object.TTextLabel (Id)
	If (BCF <> Null)
		BCF\Px=Px
		BCF\Py=Py
	EndIf
End Function

; --------------------------------------------------------------
; Permet de changer la couleur d'un LabelText
; --------------------------------------------------------------
Function BCF_ChangeLabelTextColor(Id,Red,Green,Blue)
	BCF.TTextLabel = Object.TTextLabel (Id)
	If (BCF <> Null)
		BCF\Red=Red
		BCF\Green=Green
		BCF\Blue=Blue
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; --------------------------------------------
; Innitialisation des ComboxBox
; ---------------------------------------------
Function BCF_CreateComboBox( WinId,Px,Py,Tx,Lh)

	BCF.TComboBox=New TComboBox
	BCF\Id = Handle(BCF)
	BCF\WinId = WinId
	BCF\Px = Px
	BCF\Py = Py
	BCF\Tx = Tx
	BCF\Ty = 18
	BCF\ListH = Lh
	
	BCF\Visible = True
	BCF\Enable = True

	; --------------------------------------------
	; Creation des images du gadget
	; --------------------------------------------
	BCF\BackGround1=BCF_Make3dBarImage(0,0,BCF\Tx-19,BCF\Ty,1,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
	BCF\BackGround2=BCF_Make3dBarImage(0,0,18,18,1,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))

	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If winId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	BCF\ListId = BCF_CreateListBox(BCF\WinId,Px,Py+19,Tx,BCF\ListH,False,True )
	BCF\Id_down = BCF_CreateButton(BCF\Id,Tx-17,1,14,14,"",97)
	
	Return BCF\Id
End Function

; -----------------------------------
; Gestion des ComboxBox
; -----------------------------------
Function BCF_RenderComboBox(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont

	For BCF.TComboBox = Each TComboBox
		Viewport 0, 0,GraphicsWidth(), GraphicsHeight()
		
		If (BCF\WinId = ParentWindow\Id And BCF\Visible)  Then
			TmpX=BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
			TmpY=BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre

			; -----------------------------------------------------------------------------------------------------------
			; Affichage de la combo et definition du ;Viewport pour les debordements de texte
			; -----------------------------------------------------------------------------------------------------------
			DrawImage BCF\BackGround1,TmpX,TmpY
			DrawImage BCF\BackGround2,TmpX+BCF\Tx-18,TmpY
			
			BCF_TestComboBoxButton( Handle(BCF) , TmpX , TmpY , ParentWindow\active,BCF\Enable)

			; -----------------------------------------------------
			; Affichage du texte qui a ete selectionné
			; -----------------------------------------------------
			Viewport TmpX, TmpY,BCF\Tx-19,BCF\Ty
			
			BCF_Color(Bcf_Color03)
			Text TmpX+5 , TmpY+2 , BCF\Selection$

			If ParentWindow\Active Then
			; ----------------------------------------------------------------
			; Test afin de rendre la main aux autres fenêtres
			; ----------------------------------------------------------------
			If (BCF_MouseRelease_L And BCF_ComboSelection) Or (BCF_TestActiveComboBox()=False And BCF_MouseClicked_L ) Then
				BCF_ComboSelection=False
				BCF_TestCloseComboBox()
			EndIf

			; -----------------------------------------------------------
			; Recupere la selection faite dans la ListBox
			; -----------------------------------------------------------
			If BCF_ComboSelection Then
				BCF\Selection$ = BCF_TestListBox$( BCF\ListId )
				BCF\Type_selection = BCF_TestListBoxType( BCF\ListId )
			EndIf
				
			; -------------------------------------------
			; Test de l'ouverture de la combo
			; -------------------------------------------		
			If BCF_TestButton(BCF\Id_down)  And ((BCF_ComboVisible=True And BCF_IdComboVisible=BCF\ListId) Or (BCF_ComboVisible=False And BCF_MenuActif=False)) Then
				BCF_TestListBoxVisible( BCF\ListId  )
			EndIf

			EndIf
			
		EndIf
	Next

	; ---------------------------------------
	; Retablissement du ;Viewport
	; ---------------------------------------
	Viewport 0, 0,GraphicsWidth(), GraphicsHeight()
End Function

; -----------------------------------------------------------------
; Retourne la valeur string de l'item selectionnee
; -----------------------------------------------------------------
Function BCF_TestComboBox$( Id )
	BCF.TComboBox = Object.TComboBox (Id)
	If (BCF <> Null)
		Return  BCF\Selection$
	EndIf
End Function

; -----------------------------------------------------------------
; Retourne la valeur Type de l'item selectionnee
; -----------------------------------------------------------------
Function BCF_TestComboBoxType( Id )
	BCF.TComboBox = Object.TComboBox (Id)
	If (BCF <> Null)
		Return  BCF\Type_Selection
	EndIf
End Function

; ---------------------------------------
; Ferme la ComboBox ouverte
; ---------------------------------------
Function BCF_TestCloseComboBox()
	For BCF.TListBox = Each TListBox
		If BCF\Visible=True And BCF\Combo Then
			BCF\visible=False
			BCF_ComboVisible= False
			BCF_IdComboVisible=-1
			Exit
		EndIf
	Next
End Function

; -----------------------------------------------------------------
;-Gestion du gadget d'ouverture des ComboxBox
; -----------------------------------------------------------------
Function BCF_TestComboBoxButton( hCombo ,CmbX, CmbY , bActif,Enable)
	ParentList.TComboBox = Object.TComboBox( hCombo)
	
	 For BCF.TButton = Each TButton	

	 	If BCF\WinId = ParentList\Id  Then

			BCF\ButtonState=1
			BCF\Enable=Enable
			
			TmpX = CmbX + BCF\Px
			TmpY = CmbY + BCF\Py
			
			If bActif  Then
				If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx+2 , BCF\Ty+2 ,True) And BCF\Enable=True Then
					If BCF_MouseClicked_L Then
						 BCF\ButtonState=2
					Else 
						If BCF_MouseRelease_L Then
							BCF\ButtonState=3
						Else 
							BCF\ButtonState=1
						EndIf
					EndIf				
				EndIf
			EndIf

			; ---------------------------
			; Affichage du bouton
			; ---------------------------
			Select BCF\ButtonState
			Case 1
				If BCF\Enable=True
					DrawImage BCF\ButtonState1,TmpX,TmpY
				Else
					DrawImage BCF\ButtonState3,TmpX,TmpY
				EndIf				
			Case 2
				DrawImage BCF\ButtonState2,TmpX,TmpY
			End Select
		EndIf			
	Next
End Function

Function BCF_SelectedComboBoxType( id,TypeItem )
	bfind=False
	
	; --------------------------------
	; On recherche la combo
	; --------------------------------
	BCFC.TComboBox = Object.TComboBox (Id)
	If (BCFC<> Null)
		IdList = BCFC\ListId
		bfind = True
	EndIf

	; -------------------------------
	; Est ce que l'item existe
	; -------------------------------
	If bFind Then
		ind=0
		bfind=False
		For BCF.TItem = Each TItem
			If BCF\Id_list = IdList  Then
				ind=ind+1
				If BCF\nType = TypeItem  Then
					value$= BCF\label$
					bFind = True
					Exit
				EndIf	
			EndIf
		Next
	EndIf
	
	BCF_SelectedComboBoxValue( Id , value$ )

	Return bFind
End Function

; --------------------------------------------------------------------------
; Permet  de selection un item dans une ComboBox
; --------------------------------------------------------------------------
Function BCF_SelectedComboBoxValue( Id , label$ )
	bfind=False
	
	; --------------------------------
	; On recherche la combo
	; --------------------------------
	BCFC.TComboBox = Object.TComboBox (Id)
	If (BCFC <> Null)
		BCFC\Selection$=label$
		IdList = BCFC\ListId
		bfind = True
	EndIf
	
	; -------------------------------
	; Est ce que l'item existe
	; -------------------------------
	If bFind Then
		ind=0
		bfind=False
		For BCF.TItem = Each TItem
			If BCF\Id_list = IdList  Then
				ind=ind+1
				
				If BCF\label$ = label$  Then
					typeitem=BCF\ntype
					bFind = True
					Exit
				EndIf	
			EndIf
		Next
	EndIf
	
	; -------------------------------------------------------
	; On recherche la listbox pour la selection
	; -------------------------------------------------------
	If bFind Then
		bfind=False
		BCFL.TListBox = Object.TListBox (IdList)
		If (BCFL <> Null)
			BCFL\Selection$=label$
			BCFL\Index_selection = ind-1
			BCFL\Type_Selection=typeitem
			BCF_ComboSelection=True
			
			bfind = True
		EndIf
	EndIf

	Return bFind
End Function

; -------------------------------------------------------------------------------------------------------------------------
; Permet de connaitre si la souris se situe sur la ListBox associee a la ComboBox ouverte
; ------------------------------------------------------------------------------------------------------------------------
Function BCF_TestActiveComboBox()
	BCF.TListBox = Object.TListBox (BCF_IdComboVisible)
	If (BCF <> Null)
		If BCF_Move3DMouse( BCF\ListTx , BCF\ListTy-18 , BCF\tx  , BCF\Ty+14 )  Then
			Return True
		Else
			Return False
		EndIf
	EndIf
End Function

; ---------------------------------------------------------------
; Permet d'effacer un item dans une ComboBox
; ---------------------------------------------------------------
Function BCF_KillComboBoxItem( Id,Label$ )
	BCF.TComboBox = Object.TComboBox (Id)
	If (BCF <> Null)
		BCF_KillListBoxItem( BCF\ListId , Label$ )
	EndIf
End Function

; ------------------------------------------------
; Permet de détruire une ComboBox
; ------------------------------------------------
Function BCF_KillComboBox( Id )
	BCF.TComboBox = Object.TComboBox (Id)
	If (BCF <> Null)
		BCF_KillButton( BCF\Id_down )
		BCF_KillListBox( BCF\ListId )
		
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\BackGround1
		FreeImage BCF\BackGround2

		Delete BCF
	EndIf
End Function

; --------------------------------------------------------------
; Supprime toutes les ComboBox d'une fenetre
; --------------------------------------------------------------
Function BCF_KillComboBoxChild( IdWin )
	For BCF.TComboBox = Each TComboBox
		If BCF\WinId=IdWin Then
			BCF\Selection=""
			BCF_KillComboBox(BCF\Id)
		EndIf
	Next
End Function

; ------------------------------------------------------------
; Permet d'effacer le contenu d'une ComboBox
; ------------------------------------------------------------
Function BCF_ClearComboBox( Id )
	BCF.TComboBox = Object.TComboBox (Id)
	If (BCF <> Null)
		BCF\Selection=""
		BCF_KillItemChild( BCF\ListId )
	EndIf
End Function

; ---------------------------------------
; Ajout un item a la combo list
; ---------------------------------------
Function BCF_AddComboBoxItem( IdCombo , label$="" , icon=-1 , nType=-1)
	BCF.TComboBox = Object.TComboBox (IdCombo)
	If (BCF <> Null)
		BCF_AddListBoxItem( BCF\ListId , label$ , icon ,nType )
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ----------------------------------
; initialisation des ListBox
; ----------------------------------
Function BCF_CreateListBox(WinId,Px,Py,Tx,Ty , visible=True , combo=False )

	BCF.TListBox = New TListBox
	BCF\Id = Handle(BCF)
	BCF\WinId=WinId
	BCF\indexItem=-1
	BCF\Px=Px
	BCF\Py=Py
	BCF\Tx=Tx
	BCF\Ty=Ty
	BCF\Indexscroll=0
	BCF\Nb_item=0
	BCF\Nb_itemvisible=(Ty/18)
	BCF\SlIder_Y = 0
	BCF\SlIder_H = Ty-36
	BCF\SlIder_move=False
	BCF\Index_selection=-1
	BCF\Visible = visible
	
	BCF\VisibleNotCombo = True

	; --------------------------------------------------
	; Est-ce la ListBox d'une ComboBox ?
	; --------------------------------------------------
	BCF\Combo = combo
	
	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If winId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	; -------------------------------------------
	; Creation des gadget up & down
	; -------------------------------------------
	BCF\Id_up = BCF_CreateButton(BCF\Id ,Tx-17,1,14,14,"",96) 
	BCF\Id_down = BCF_CreateButton(BCF\Id,Tx-17,Ty-17,14,14,"",97) 

	; ---------------------------------------------------------
	; Creation des deux fonds (liste+ascenceur)
	; ---------------------------------------------------------
	BCF\Background1=BCF_Make3dBarImage(0,0,BCF\Tx-19,BCF\Ty,1,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
	BCF\Background2=BCF_Make3dBarImage(0,0,18,BCF\Ty,1,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02))
	
	Return BCF\Id
End Function

; ---------------------------
; Gestion des ListBox
; ---------------------------
Function BCF_RenderListBox(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)

	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont
	
	 For BCF.TListBox = Each TListBox

		nTime = 130
		
	 	Mouse_clickedUp=False
		Mouse_clickedDown=False

		Viewport 0, 0,GraphicsWidth(), GraphicsHeight()
		
		If (BCF\WinId = ParentWindow\Id  And BCF\Visible=True And BCF\VisibleNotCombo = True) Then
			TmpX=BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
			TmpY=BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre

			; ------------------------------------------------
			; On memorise la position de la liste
			; ------------------------------------------------
			BCF\ListTx = TmpX
			BCF\ListTy = TmpY
			
			; ------------------------------------------
			; On affiche le fond de la ListBox
			; ------------------------------------------
			DrawImage BCF\BackGround2,TmpX+BCF\Tx-18 ,TmpY
			DrawImage BCF\BackGround1,TmpX,TmpY
			
			; -----------------------------------
			; Tert du bouton Ascenceur
			; -----------------------------------
			BCF_TestListBoxScroller( Handle(BCF) , TmpX , TmpY , ParentWindow\active)

			; -------------------------------------------
			; Affichage du bouton Ascenceur
			; -------------------------------------------
			TmpAX= BCF\Px + ParentWindow\Px+2 + BCF\Tx - 17
			TmpAY=BCF\Py  + ParentWindow\Py+2  +  BCF\SlIder_Y + 39

			BCF_Draw3dBar( TmpAX , TmpAY,16 , BCF\SlIder_H,1,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
			
			; ----------------------
			; Si fenetre active
			; ----------------------
			If ParentWindow\active Then
				; ----------------------------------
				; Somme nous sur la liste
				; ----------------------------------
				If  BCF_Move3DMouse( TmpX , TmpY , BCF\tx , BCF\Ty ) And ((BCF_ComboVisible=False And BCF_MenuActif=False) Or (BCF_IdComboVisible=BCF\Id And BCF_ComboVisible=True)) Then

					bMouselist=True
					Index_sel=(MouseY() - TmpY) / 18
					
					; ----------------------------------
					; On selectionne un Item ?
					; ----------------------------------
					If BCF_MouseClicked_L And BCF_Move3DMouse( TmpX , TmpY , BCF\tx -16  , BCF\Ty, True ) Then
						If (BCF\Indexscroll +  Index_sel) <=BCF\Nb_item-1 Then
							BCF\Index_Selection = BCF\Indexscroll +  Index_sel
							BCF_ComboSelection = True
						EndIf
					Else
						; --------------------------------------------------
						; Si nous somme sur une ComboBox
						; --------------------------------------------------
						If BCF\Combo Then
							If (BCF\Indexscroll +  Index_sel) <=BCF\Nb_item-1 And Index_sel<BCF\Nb_itemvisible Then
								BCF_Draw3dBar( TmpX+1 , (TmpY+1)+18*Index_sel ,BCF\Tx-20 , 15 ,5 ,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
							EndIf
						EndIf
					EndIf
				Else
					bMouselist=False
				EndIf

				; -----------------------------------------------------------------
				; Avons nous clique dans la zone de l'ascenseur
				; -----------------------------------------------------------------
				If  BCF_Move3DMouse( TmpAX , TmpY+16  ,16 , BCF\Ty-32,True ) And MouseDown(1) Then
					If MouseY() < TmpY + BCF\SlIder_Y# + 16 Then
						Mouse_clickedUp=True
						nTime=0
					Else
						Mouse_clickedUp=False
					EndIf

					If MouseY()> TmpY + BCF\SlIder_Y# + BCF\Slider_h# Then
						Mouse_clickedDown=True
						nTime=0
					Else
						Mouse_clickedDown=False
					EndIf
				Else
					Mouse_clickedUp=False
					Mouse_clickedDown=False
				EndIf
				
				; -------------------------------------------------------
				; Actionne t- on l'ascenseur avec la souris
				; -------------------------------------------------------
				If  BCF_Move3DMouse( TmpAX , TmpAY, 16 , BCF\SlIder_H# ,True) And BCF_MouseClicked_L And BCF\Nb_item>0 Then
					If BCF\SlIder_move=False Then
						BCF\SlIder_move = True
						BCF\DragY = MouseY() - BCF\SlIder_Y
					EndIf
				Else
					If  BCF_MouseClicked_L = False Then 
						BCF\SlIder_move = False
					EndIf
				EndIf

				; -------------------------------------------------------------------------
				; Gestion du deplacement de l'ascenseur par la souris
				; -------------------------------------------------------------------------
				If BCF\SlIder_move Then
					; ------------------------------
					; Calcul de la postion Y
					; ------------------------------
					TmpSlIder_y# = BCF\SlIder_Y#
					BCF\SlIder_Y#  = BCF_MouseY- BCF\DragY
					
					; -------------------------------------------------------------------------
					; Limitation de la zone de scroll du bouton d'ascenseur
					; -------------------------------------------------------------------------
					If BCF\SlIder_Y#<0 Then
						BCF\SlIder_Y# = TmpSlIder_y#
					EndIf

					If BCF\SlIder_Y# >BCF\Nb_pas *  BCF\Hauteur_pas# Then

						BCF\SlIder_Y#= TmpSlIder_y#
					EndIf
						
					; ------------------------------------
					; Calcul de la valeur d'index
					; ------------------------------------
					BCF\Indexscroll= BCF\SlIder_Y / BCF\Hauteur_pas#	
					
					; --------------------------------------------------------------------------------------------------------------------------------------
					; Pour faire en sorte que le pointeur se coince sur l'ascenceur et eviter la selection d'autres gadgets
					; --------------------------------------------------------------------------------------------------------------------------------------
					MoveMouse TmpAX+8,MouseY() ; 8=Largeur de l'ascenceur
				Else
					; ----------------------------------------------------
					; Gestion par les gadgets HAUT et BAS
					; ----------------------------------------------------
					BCF\SlIder_Y# = BCF\Indexscroll * BCF\Hauteur_pas#

					If BCF_MouseZSpeed>0 Then
						nTime =0
						bWheelUp=True
					Else
						bWheelup=False
					EndIf

					If BCF_MouseZSpeed<0 Then
						nTime = 0
						bWheelDown=True
					Else
						bWheelDown=False
					EndIf
					
					; -------------------
					; Gadget HAUT
					; -------------------
					If  BCF_TestButton(BCF\Id_up)  Or (bWheelUp And bMouselist ) Or Mouse_clickedUp Then
						If BCF\Indexscroll>=1 And (BCF_TimeOut(BCF_ListTimer) Or bWheelUp ) Then
							BCF_ListTimer=BCF_SetTimer( nTime )
							BCF\Indexscroll=BCF\Indexscroll-1
						EndIf
					EndIf

					; ------------------
					; Gadget down
					; ------------------
					If  BCF_TestButton(BCF\Id_down) Or (bWheelDown And bMouselist) Or Mouse_clickedDown Then
						If BCF\Nb_item-BCF\Indexscroll>BCF\Nb_itemvisible And (BCF_TimeOut(BCF_ListTimer)  Or bWheelDown )Then
							BCF_ListTimer=BCF_SetTimer( nTime )
							BCF\Indexscroll=BCF\Indexscroll+1
						EndIf
					EndIf
				EndIf
			EndIf

			; --------------------------------
			; Affichage des données
			; --------------------------------
			i=0 : j=0 : SetFont  BCF_InterfaceFont
			
			For Item.TItem = Each TItem
				If  Item\Id_list=BCF\Id Then
					If i>=BCF\Indexscroll Then
						; --------------------------------------
						; Est ce l'item selectionne ??
						; --------------------------------------
						If i=BCF\Index_selection Then
							BCF\Selection$ = Item\label$
							BCF\Type_Selection = Item\nType
							bSelection=True
						Else
							bSelection=False
						EndIf
							
						; ------------------------------------------------------------------------------------
						; Si on ne depasse pas la taille de la liste  on affiche la donnée
						; ------------------------------------------------------------------------------------
						If Tmpy+18*j + 12 < Tmpy+BCF\Ty Then
							; ------------------------------------------------------------
							; Si c'est la selection affichage de la barre 3D
							; ------------------------------------------------------------
							If bSelection Then
								BCF_Draw3dBar( TmpX+1 , (TmpY+1)+18*j ,BCF\Tx-20 ,15 ,5 ,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
							EndIf

							
							; ------------------------------------------------------------------------------------------------
							; Affichage du label selectionné dans la ListBox avec gestion du ;Viewport
							; ------------------------------------------------------------------------------------------------
							BCF_Color(Bcf_Color03)
							
							; --------------------------------------------------------------------------
							; Definition du ;Viewport pour les debordements de texte
							; --------------------------------------------------------------------------
							Viewport TmpX, TmpY-23,BCF\Tx-19,BCF\Ty+23 ; -23 et +23 taille de la barre de titre de la fenetre
							
							; -------------------------------------------------
							; Affichage des icones dans la listbox
							; -------------------------------------------------
							If item\icon > -1 Then
								DrawImage item\icon,TmpX+5,(TmpY+18*j)+1
								Text TmpX+25,(TmpY+18*j)+1,Item\label$
							Else
								Text TmpX+5,(TmpY+18*j)+1,Item\label$
							EndIf
												
							j=j+1
						Else
							Exit
						EndIf	
					EndIf
					
					i=i+1
				EndIf
			Next
		EndIf
	Next	
		
	; ---------------------------------------
	; Retablissement du ;Viewport
	; ---------------------------------------
	Viewport 0, 0,GraphicsWidth(), GraphicsHeight()
End Function

; -----------------------------------------------------------------
; Retourne la valeur string de l'item selectionnee
; -----------------------------------------------------------------
Function BCF_TestListBox$( Id )
	BCF.TListBox = Object.TListBox (Id)
	If (BCF <> Null)
		Return  BCF\Selection$
	EndIf
End Function

; ------------------------------------------------------
; Retourne le nombre d'item d'une listbox
; ------------------------------------------------------
Function BCF_TestListBoxItemNumber( Id )
	BCF.TListBox = Object.TListBox (Id)
	If (BCF <> Null)
		For TmpCount.TItem = Each TItem
			Tmp_ItemNumber=Tmp_ItemNumber+1
		Next
	EndIf

	Return Tmp_ItemNumber
End Function

; ------------------------------------------------------
; Retourne le nombre d'item d'une listbox
; ------------------------------------------------------
Function BCF_SelectedListBoxValue( Id , label$ )
        bfind=False
        
        ; --------------------------------
        ; On recherche la combo
        ; --------------------------------
        BCFL.TListBox = Object.TListBox (Id)
        If (BCFL = Null) Then Return False

        ; -------------------------------
        ; Est ce que l'item existe
        ; -------------------------------
        ind=0
        bfind=False
        For BCF.TItem = Each TItem
                If BCF\Id_list = Id Then
                        ind=ind+1               
                        If BCF\label$ = label$  Then
                                typeitem=BCF\ntype
                                bFind = True
                                Exit
                        EndIf   
                EndIf
        Next
        
        ; -------------------------------------------------------
        ; On recherche la listbox pour la selection
        ; -------------------------------------------------------
        If bFind Then
                BCFL\Selection$=label$
                BCFL\Index_selection = ind-1
                BCFL\Type_Selection=typeitem
                BCF_ComboSelection=True 
        EndIf
        
        Return bFind
End Function

; ----------------------------------------------------------------------------------
; Permet de switcher l'affichage de la listbox d'une combobox
; ----------------------------------------------------------------------------------
Function BCF_TestListBoxVisible( IdList )
	BCF.TListBox = Object.TListBox (IdList)
	If (BCF <> Null)
		If BCF\Visible Then
			BCF\visible=False
			BCF_ComboVisible= False
			BCF_IdComboVisible=-1
		Else
			BCF\visible=True
			BCF_ComboVisible= True
			Insert BCF After Last TListBox
			BCF_IdComboVisible=BCF\Id
		EndIf
	EndIf
End Function

; -----------------------------------------------------------------------------------------
; Renvoie le champ type de la liste box, utilisé pour le file requester
; -----------------------------------------------------------------------------------------
Function BCF_TestListBoxType( Id )
	BCF.TListBox = Object.TListBox (Id)
	If (BCF <> Null)
		Return  BCF\Type_Selection
	EndIf
End Function

; --------------------------------------------------------------
; Gestion des gadget Up & Down de la ListBox
; --------------------------------------------------------------
Function BCF_TestListBoxScroller( hList ,ListX, ListY , bActif)
	ParentList.TListBox = Object.TListBox( hList)
	
	 For BCF.TButton = Each TButton	
	 	If BCF\WinId = ParentList\Id  Then
			BCF\ButtonState=1
			
			TmpX = ListX + BCF\Px
			TmpY = ListY + BCF\Py
			
			If bActif  Then
				If BCF_Move3DMouse( TmpX , TmpY, BCF\Tx+2 , BCF\Ty+2,True ) Then
					If BCF_MouseClicked_L Then
						 BCF\ButtonState=4
					Else 
						BCF\ButtonState=1
					EndIf				
				EndIf
			EndIf

			; ---------------------------
			; Affichage du bouton
			; ---------------------------
			Select BCF\ButtonState
			Case 1
				DrawImage BCF\ButtonState1,TmpX,TmpY
			Case 4
				DrawImage BCF\ButtonState2,TmpX,TmpY
			End Select
		EndIf			
	Next
End Function

; --------------------------------------
; Ajout d'un item dans la liste
; --------------------------------------
Function BCF_ListBoxNewItem( Idlist)
	BCF.TListBox = Object.TListBox (IdList)
	If (BCF <> Null)
		; ----------------------------------------------		
		; Calcul de l'index unique d'un item
		; ----------------------------------------------
		BCF\indexitem=BCF\indexitem+1

		; --------------------------------------------------------			
		; Calcul du nombre d'item dans la ListBox
		; --------------------------------------------------------
		BCF\Nb_item = BCF\Nb_item +1
			
		; -----------------------------------
		; Calcul du nombre de pas
		; -----------------------------------
		BCF\Nb_pas=BCF\Nb_Item - (BCF\Ty /18 ) 
		If BCF\Nb_pas<0 Then BCF\Nb_pas=0

		; ---------------------------------------------------------------
		; Calcul de la hauteur du bouton de l'ascenseur
		; ---------------------------------------------------------------
		If BCF\Nb_pas>1 Then
			BCF\SlIder_H = (BCF\Ty - 36) /  BCF\Nb_pas
		Else
			If BCF\Nb_pas= 1 Then
				BCF\SlIder_H = (BCF\Ty - 36) / 2
			EndIf
		EndIf

		; ------------------------------------------------------------------------------
		; Limitation minimale de la taille du bouton de l'ascenseur
		; ------------------------------------------------------------------------------
		If BCF\SlIder_H#<8 Then BCF\SlIder_H#=8

		; ---------------------------------------------------------------------------------------------------------
		; Calcul de la hauteur du pas en fonction de la taille du bouton de  l'ascenseur
		; ---------------------------------------------------------------------------------------------------------
		If  BCF\Nb_pas>0 Then
			BCF\Hauteur_pas# = ((BCF\Ty - 36 - BCF\SlIder_H# ) / (BCF\Nb_pas)) ; Hauteur de la liste = Les boutons UP & DOWN / Le nombre de pas
		Else
			BCF\Hauteur_pas#=BCF\Ty - 36
		EndIf

		Return BCF\indexitem
	EndIf
End Function

; ------------------------------------------------------
; Retourne l'index de l'item d'une list box
; -----------------------------------------------------
Function BCF_TestIndexListBox( Id )
	BCF.TListBox = Object.TListBox (Id)
	If (BCF <> Null)
		Return  BCF\Index_Selection
	EndIf
End Function

; --------------------------------------------
; Permet de détruire une InputBox
; --------------------------------------------
Function BCF_KillListBox( Id )
	BCF.TListBox = Object.TListBox (Id)
	If (BCF <> Null)
		; ---------------------
		; Kill les boutons
		; ---------------------
		BCF_KillButton(BCF\Id_up)
		BCF_KillButton( BCF\Id_down)
		BCF_KillItemChild(BCF\Id)

		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\BackGround1
		FreeImage BCF\BackGround2
		
		Delete BCF
	EndIf
End Function

; ----------------------------------------------------------
; Permet d'effacer un item dans une ListBox
; ----------------------------------------------------------
Function BCF_KillListBoxItem( Id, Label$ )
	For BCF.TItem = Each TItem
		If BCF\Id_list = Id And BCF\label$=Label$ Then
			Delete BCF
			Exit
		EndIf
	Next
End Function

; -----------------------------------------------------------
; Supprime toutes les ListBox d'une fenentre
; -----------------------------------------------------------
Function BCF_KillListBoxChild(IdWin)
	For BCF.TListbox = Each TListbox
		If BCF\WinId=IdWin Then
			BCF\Selection=""
			BCF\Index_selection=0

			; ---------------------
			; Kill les boutons
			; ---------------------
			BCF_KillButton(BCF\Id_up)
			BCF_KillButton( BCF\Id_down)
			BCF_KillItemChild(BCF\Id)

			; ---------------------------
			; Et le fond des listes
			; ---------------------------
			FreeImage BCF\BackGround1
			FreeImage BCF\BackGround2
			
			Delete BCF
		EndIf
	Next
End Function

; -----------------------------------------------------
; Supprime tous les items d'une ListBox
; -----------------------------------------------------
Function BCF_KillItemChild(IdList)
	; ------------------------------
	; On supprime les item
	; ------------------------------
	For BCF.TItem = Each TItem
		If BCF\Id_list = IdList Then
			FreeImage  BCF\Icon
			Delete BCF
		EndIf
	Next

	; -------------------------------------
	; On reinitialise le compteur
	; -------------------------------------
	BCFL.TListBox = Object.TListBox (IdList)
	If (BCFL <> Null)
		BCFL\Nb_item=0
		BCFL\Selection$=""
		BCFL\Indexscroll=0
		BCFL\Index_selection=-1
		BCFL\SlIder_Y#=0
		BCFL\SlIder_H# = BCFL\Ty-36
	EndIf
End Function

; ---------------------------------------------------------
; Permet d'effacer le contenu d'une ListBox
; ---------------------------------------------------------
Function BCF_ClearListBox( Id )
	BCF_KillItemChild( Id )
End Function

; ----------------------------------
; Ajout un item a la ListBox
; ----------------------------------
Function BCF_AddListBoxItem( IdList , label$="" , icon=-1 , nType=-1)

	BCF.TItem = New TItem
	BCF\Id = Handle(BCF)
	BCF\Id_list = IdList
	BCF\label$=label$
	BCF\index = BCF_ListBoxNewItem(IdList  )
	BCF\nType = nType
	
	If icon>-1 Then
		BCF\icon = BCF_ReadRawImage(Icon)
	Else
		BCF\icon =-1
	EndIf
	
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ----------------------------------------
; Permet de définir les gauges
; ----------------------------------------
Function BCF_CreateGauge(WinId,Px,Py,Tx,Ty,Value,Max,Label$,Style,Red,Green,Blue)
	
	BCF.TGauge=New TGauge
	BCF\Id=Handle(BCF)
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py
	BCF\Tx=Tx
	BCF\Ty=Ty
	BCF\Value=Value
	BCF\Max=Max
	BCF\Label$=Label$
	BCF\Style=Style
	BCF\Red=Red
	BCF\Green=Green
	BCF\Blue=Blue
	
	BCF\Visible = True
	
	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	Return BCF\Id
End Function

; -----------------------------------------
; Rafraichissement les gauges
; -----------------------------------------
Function BCF_RenderGauge(hWindow)
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	For BCF.TGauge= Each TGauge
		; ----------------------------------------------------------
		; Si le State de la fenetre est 0 (non réduite) 
		; ----------------------------------------------------------
		If (BCF\WinId = ParentWindow\Id And ParentWindow\State=0 And BCF\Visible) Then
			; ---------------------------------------------------
			; On cherche l'offset X et Y de la fenetre
			; ---------------------------------------------------
			TmpX=BCF\Px+ParentWindow\Px+2   ; 2=Bordure 3D de la gauche de la fenetre
			TmpY=BCF\Py+ParentWindow\Py+23 ; 20=Hauteur de la barre de titre

			BCF_DrawGauge(TmpX,TmpY,BCF\Tx,BCF\Ty,BCF\Value,BCF\Max,BCF\Label$,BCF\Style,BCF\Red,BCF\Green,BCF\Blue)
		EndIf
	Next
End Function

; -----------------------------------------------
; Fonction pour afficher des Gauges
; -----------------------------------------------
Function BCF_DrawGauge(Px,Py,Tx,Ty,Valeur,ValeurMax,Caption$,Style,Red,Green,Blue)
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont
	
	; ----------------------------
	; On efface le contenu
	; ----------------------------
	BCF_Draw3dBar(Px,Py,Tx,Ty,2,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
	
	; ------------------------------------------
	; Calcul de la valeur de la gauge
	; ------------------------------------------
	Local BCF_TmpGauge=Valeur*(Tx-3)/ValeurMax     ; Definition de la valeur de la gauge

	; --------------------------------------------------
	; Affichage de la barre de progression
	; --------------------------------------------------
	Select Style
	Case 1 
		BCF_DrawGradientBar(Px+2,Py+2,BCF_TmpGauge,Ty-4,Red/2,Green/2,Blue/2,Red,Green,Blue,1)
	Case 2
		BCF_DrawGradientBar(Px+2,Py+2,BCF_TmpGauge,Ty-4,Red/2,Green/2,Blue/2,Red,Green,Blue,1)
	Case 3
		BCF_DrawGradientBar(Px+2,Py+2,BCF_TmpGauge,Ty-4,Red/2,Green/2,Blue/2,Red,Green,Blue,1)
	End Select

	; ---------------------------
	; Gestion du viewport
	; ---------------------------
	Viewport Px+2 ,Py,Tx -4, Ty
	
	; ----------------------------------------------------------------------------------------------------
	; Le texte de la gauge calcul d'un pourcentage : "(100*(Valeur))/ValeurMax"
	; ----------------------------------------------------------------------------------------------------
	If Caption$<>False Then
		BCF_Color(Bcf_Color03)
		Text Px+Tx/2,Py+Ty/2,(100*(Valeur))/ValeurMax+"% ("+Caption$+")",True,True
	EndIf

	; -------------------------------------
	; Reinitialisation du viewport
	; -------------------------------------
	Viewport 0, 0,GraphicsWidth(), GraphicsHeight()
End Function

; --------------------------------------
; Permet d'effacer une Gauge
; --------------------------------------
Function BCF_KillGauge(Id)
	BCF.TGauge = Object.TGauge (Id)
	If (BCF <> Null)
		Delete BCF
	EndIf
End Function

; ----------------------------------------------------------
; Supprime toutes les gauges d'une fenetre
; ----------------------------------------------------------
Function BCF_KillGaugeChild( IdWin )
	For BCF.TGauge = Each TGauge
		If BCF\WinId=IdWin Then
			BCF_KillGauge(BCF\Id)
		EndIf
	Next
End Function

; ----------------------------------------------------------
; Permet de changer la couleur d'une gauge
; ----------------------------------------------------------
Function BCF_ChangeGaugeColor(Id,Red,Green,Blue)
	BCF.TGauge = Object.TGauge (Id)
	If (BCF <> Null)
		BCF\Red=Red
		BCF\Green=Green
		BCF\Blue=Blue
	EndIf
End Function

; ---------------------------------------------------------------------
; Permet de changer la barre de valeur d'une gauge
; ---------------------------------------------------------------------
Function BCF_ChangeGaugeValue(Id,Value)
	BCF.TGauge = Object.TGauge (Id)
	If (BCF <> Null)
		BCF\Value=Value
	EndIf
End Function

; -----------------------------------------------------------------------
; Permet de changer la valeur maximale d'une gauge
; -----------------------------------------------------------------------
Function BCF_ChangeGaugeMax(Id,Max)
	BCF.TGauge = Object.TGauge (Id)
	If (BCF <> Null)
		BCF\Max=Max
	EndIf
End Function

; ----------------------------------------------------------
; Permet de changer le caption d'une gauge
; ----------------------------------------------------------
Function BCF_ChangeGaugeLabel(Id,Label$)
	BCF.TGauge = Object.TGauge (Id)
	If (BCF <> Null)
		BCF\Label$=Label$
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; -------------------------------------------
; Permet de définir les Infos Text
; -------------------------------------------
Function BCF_CreateInfoText(Px,Py,Tx,Ty,Style,Label$)
	
	BCF.TInfoText=New TInfoText
	BCF\Id=Handle(BCF)
	BCF\Px=Px
	BCF\Py=Py
	BCF\Tx=Tx
	BCF\Ty=Ty
	BCF\Style=Style
	BCF\Label$=Label$
	
	BCF\Visible = True

	Return BCF\Id
End Function

; ----------------------------------------------
; Rafraichissement des Infos Text
; ----------------------------------------------
Function BCF_RenderInfoText()
	For BCF.TInfoText = Each TInfoText
		BCF_DrawInfoText(BCF\Px,BCF\Py,BCF\Tx,BCF\Ty,BCF\Style,BCF\Label$)	
	Next
End Function

; --------------------------------------------------
; Fonction pour afficher des infos texte
; --------------------------------------------------
Function BCF_DrawInfoText(Px,Py,Tx,Ty,Style,Label$)
	; ----------------------------------------
	; Definition de la fonte correcte
	; ----------------------------------------
	SetFont  BCF_InterfaceFont
	
	; -----------------------------
	; Contour de l'info texte
	; -----------------------------
	Select Style
	Case 1
		BCF_Draw3dBar(Px,Py,Tx,Ty,1,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
	Case 2
		BCF_Draw3dBar(Px,Py,Tx,Ty,4,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
	End Select
	
	; ------------------------------------------------------------------------
	; Creation du ;Viewport (pour eviter les debordements)
	; ------------------------------------------------------------------------
	Viewport Px+2,Py,Tx-4, Ty
			
	; -----------------------------
	; Le texte de l'info texte
	; -----------------------------
	BCF_Color(Bcf_Color03)
	Text Px+Tx/2,Py+Ty/2,Label$,True,True
	
	; -------------------------------------
	; Reinitialisation du ;Viewport
	; -------------------------------------
	Viewport 0, 0,GraphicsWidth(), GraphicsHeight()	
End Function

; --------------------------------------
; Permet d'effacer un InfoText
; --------------------------------------
Function BCF_KillInfoText(Id)
	BCF.TInfoText = Object.TInfoText (Id)
	If (BCF <> Null)
		Delete BCF
	EndIf
End Function

; ------------------------------------------------------
; Permet de changer le label d'un infotext
; ------------------------------------------------------
Function BCF_ChangeInfoTextLabel(Id,Label$)
	BCF.TInfoText = Object.TInfoText (Id)
	If (BCF <> Null)
		BCF\Label$=Label$
	EndIf
End Function

; -----------------------------------------------------------
; Permet de changer la position d'un infotext
; -----------------------------------------------------------
Function BCF_ChangeInfoTextPosition(Id,Px,Py)
	BCF.TInfoText = Object.TInfoText (Id)
	If (BCF <> Null)
		BCF\Px=Px
		BCF\Py=Py
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ------------------------------------
; Innitialisation des images
; ------------------------------------
Function BCF_CreateImage( WinId,Px,Py,Tx,Ty,File$ )

	BCF.TImage = New TImage
	BCF\Id = Handle(BCF)
	BCF\WinId=WinId
	BCF\Px = Px
	BCF\Py = Py
	BCF\Tx = Tx
	BCF\Ty = Ty

	If File$<>"" Then 
		BCF\Image = LoadImage( File$)
	Else
		BCF\Image = CreateImage(Tx-1,Ty-1)
	EndIf 
	
	BCF\Visible = True

	; -----------------------------------------------------------------------------------------------
	; Si la taille de l'image est comparable à la taille Tx,Ty inutile de resizer
	; -----------------------------------------------------------------------------------------------
	If ImageWidth(BCF\Image) <>Tx Or ImageHeight(BCF\Image)<>Ty Then
		ResizeImage BCF\Image, Tx-1,Ty-1
	EndIf 

	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	BCF\BackGround=BCF_Make3dBarImage(0,0,BCF\Tx,BCF\Ty,8,BCF_GetRed(Bcf_Color01),BCF_GetGreen(Bcf_Color01), BCF_GetBlue(Bcf_Color01))
	
	Return BCF\Id
End Function

; ------------------------------------------
; Rafraichissement des images
; ------------------------------------------
Function BCF_RenderImage(hWindow )
	ParentWindow.TWindow = Object.TWindow( hWindow)
	
	For BCF.TImage = Each TImage
		; ----------------------------------------------------------
		; Si le State de la fenetre est 0 (non réduite) 
		; ----------------------------------------------------------
		If (BCF\WinId = ParentWindow\Id And ParentWindow\State=0 And BCF\Visible) Then
			; ---------------------------------------------------
			; On cherche l'offset X et Y de la fenetre
			; ---------------------------------------------------
			TmpX=BCF\Px+ParentWindow\Px+2   ; 2=Bordure 3D de la gauche de la fenetre
			TmpY=BCF\Py+ParentWindow\Py+23 ; 23=Hauteur de la barre de titre

			DrawImage BCF\BackGround,TmpX,TmpY
			DrawBlock BCF\Image, TmpX+1,TmpY+1
		EndIf
	Next
End Function

; --------------------------------------
; Permet d'effacer une image
; --------------------------------------
Function BCF_KillImage( Id )
	BCF.TImage = Object.TImage (Id)
	If (BCF <> Null)
		; ---------------------------------------------
		; Liberation des images et du type
		; ---------------------------------------------
		FreeImage BCF\BackGround
		FreeImage BCF\Image
		Delete BCF
	EndIf
End Function

; ---------------------------------------------------------
; Permet d'effacer les images d'une fenetre
; ---------------------------------------------------------
Function BCF_KillImagechild( IdWin )
	For BCF.TImage = Each TImage
		If BCF\WinId = IdWin Then
			BCF_KillImage( BCF\Id)
		EndIf
	Next
End Function

; -----------------------------------------------------------------------------------
; Permet de changer l'image d'un controle image par un fichier
; -----------------------------------------------------------------------------------
Function BCF_ChangeImageBitmap( Id,file$)
	BCF.TImage = Object.TImage (Id)
	If (BCF <> Null)
		FreeImage BCF\Image
		BCF\Image = LoadImage( File$)

		; -----------------------------------------------------------------------------------------------
		; Si la taille de l'image est comparable à la taille Tx,Ty inutile de resizer
		; -----------------------------------------------------------------------------------------------
		If ImageWidth(BCF\Image) <>BCF\Tx Or ImageHeight(BCF\Image)<>BCF\Ty Then
				ResizeImage BCF\Image, BCF\Tx-1,BCF\Ty-1
		EndIf

	EndIf
End Function

; ---------------------------------------------------------------------------------------------
; Permet de changer l'image d'un controle image par un buffer image
; ---------------------------------------------------------------------------------------------
Function BCF_ChangeImageBuffer( Id,Buffer)
	BCF.TImage = Object.TImage (Id)
	If (BCF <> Null)
		FreeImage BCF\Image
		BCF\Image = Buffer

		; -----------------------------------------------------------------------------------------------
		; Si la taille de l'image est comparable à la taille Tx,Ty inutile de resizer
		; -----------------------------------------------------------------------------------------------
		If ImageWidth(BCF\Image) <>BCF\Tx Or ImageHeight(BCF\Image)<>BCF\Ty Then
				ResizeImage BCF\Image, BCF\Tx-1,BCF\Ty-1
		EndIf

	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ---------------------------------------
; Permet de créer un viewport
; ---------------------------------------
Function BCF_CreateViewport( WinId,Px,Py,Tx,Ty ,CamPosX#,CamPosY#,CamPosZ#,CamPitch#=0,CamYaw#=0,CamRoll#=0)
	BCF_TViewPort = BCF_TViewPort +1

	BCF.TBCF_ViewPort = New TBCF_ViewPort
	BCF\WinId=WinId
	BCF\Px=Px
	BCF\Py=Py
	BCF\Tx=Tx
	BCF\Ty=Ty

	BCF\Image=CreateImage( Tx,Ty)
	BCF\camera =CreateCamera()
	
	BCF\Visible = True

	; ------------------------------------
	; Test pour la fenetre virtuel
	; ------------------------------------
	If WinId=False Then
		BCF\WinId = BCF_TestVirtualParent()
		BCF_IdVirtualParent = BCF\WinId
	EndIf

	PositionEntity BCF\Camera,CamPosX#,CamPosY#,CamPosZ#
	RotateEntity BCF\Camera,CamPitch#,CamYaw#,CamRoll#
	
	Return BCF\camera
End Function

; ----------------------------------------
; Permet le rendu des viewport
; ----------------------------------------
Function BCF_RenderViewPort( hWindow )
	ParentWindow.TWindow = Object.TWindow( hWindow)

	For BCF.TBCF_ViewPort = Each TBCF_ViewPort
	 	If (BCF\WinId =  ParentWindow\Id And BCF\Visible) Then
			TmpX=BCF\Px + ParentWindow\Px+2	; 2=Bordure gauche de la fenetre
			TmpY=BCF\Py + ParentWindow\Py+23	; 23=Taille Y de la bare de titre

			MaskImage BCF\Image,255,0,255
			DrawImage BCF\Image, TmpX+1,TmpY+1
		EndIf
	Next
End Function

; -----------------------------------------
; Permet d'updater les viewport
; -----------------------------------------
Function BCF_UpdateViewPort()
	For BCF.TBCF_ViewPort = Each TBCF_ViewPort
		ShowEntity BCF\Camera
		RenderWorld()
		CameraViewport BCF\Camera,0,0,BCF\Tx,BCF\Ty
		CopyRect  0,0,BCF\Tx,BCF\Ty,0,0,BackBuffer(), ImageBuffer( BCF\Image )
		HideEntity BCF\Camera
	Next
End Function

; ---------------------------------------
; Permet d'effacer un viewport
; ---------------------------------------
Function BCF_KillIViewPort( CamId)
	For BCF.TBCF_ViewPort = Each TBCF_ViewPort
	 	If BCF\Camera = CamId Then
			FreeEntity BCF\Camera
			FreeImage BCF\Image
			Delete BCF
		EndIf
	Next
End Function

; -------------------------------------------------------
; Permet d'effacer tout les viewport enfant
; -------------------------------------------------------
Function BCF_KillViewPortchild( IdWin )
	For BCF.TBCF_ViewPort = Each TBCF_ViewPort
		If BCF\WinId = IdWin Then
			BCF_KillIViewPort(BCF\Id)
		EndIf
	Next
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ----------------------------------------
; Permet la creation d'un menu
; ----------------------------------------
Function BCF_CreateMenu( label$ ,  enabled=True )
	BCF_Menu = True
	Menu.TMenu = New TMenu
	
	Menu\TypeMenu 	= BCF_MenuMenu
	Menu\Label$		= Label$
	
	SetFont  BCF_InterfaceFont
	Menu\tx 		= StringWidth( label$)

	If TypeMenu<>BCF_MenuItemSubMenu Then
		If BCF_MenuNextX= 0 Then
			Menu\Px	= 5
		Else
			Menu\Px	= BCF_MenuNextX + 16
		EndIf
		BCF_MenuNextX = Menu\Px + StringWidth( label$) + 16
	EndIf
	
	Menu\nbItem		= 0
	Menu\Enabled		= enabled
	Menu\Open		= False 
	Menu\Py = 19
	
	Return Handle( Menu )
End Function

; ------------------------------------------------
; Permet la creation d'un sous menu
; ------------------------------------------------
Function BCF_CreateSubMenu( LinkItem  )

	Menu.TMenu = New TMenu
	Menu\TypeMenu 	= BCF_MenuSubMenu
	
	SetFont  BCF_InterfaceFont
	Menu\tx 	= StringWidth( label$)
	Menu\nbItem		= 0
	Menu\Enabled		= True
	Menu\Open		= False
	Menu\hItemChild 	= LinkItem
	
	Item.TMenuItem	= Object.TMenuItem( LinkItem )
	Item\hsubMenu	= Handle(Menu)
	Item\TypeItem		= BCF_MenuItemSubMenu
	Item\ImgSubMark=BCF_ReadRawImage(1000)
	
	Menu\hMenuParent = Item\hParent
	
	Return Handle( Menu )
End Function

; ------------------------------------
; Creation d'un popup Menu
; ------------------------------------
Function BCF_CreatePopUpMenu()

	Menu.TMenu = New TMenu
	Menu\TypeMenu 	= BCF_MenuPopUp
	
	SetFont  BCF_InterfaceFont
	Menu\Open 		= True
	Menu\nbItem		= 0
	Menu\Enabled	= True
	Menu\Open		= False
	Menu\hItemChild = False
	
	Return Handle( Menu )
	
End Function

; ------------------------------------------------------------------
; Creation d'un Item quelque soit le type du menu
; ------------------------------------------------------------------
Function BCF_CreateMenuItem (  hParent , Label$ , enabled=True , visible=True )
	Menu.TMenu = Object.TMenu(hParent )
	Item.TMenuItem 	= New TMenuItem
	Item\hParent 	= hParent
	Item\Label$ 	= label$

	If label$="" Then
		Item\TypeItem	= BCF_MenuItemSeparator
	Else 	
		Item\TypeItem	= BCF_MenuItem
	EndIf
	
	Item\Enabled	= enabled
	Item\Visible 	= visible
	Item\hsubMenu = False
	
	SetFont  BCF_InterfaceFont
	tmp = StringWidth( label$)
	If tmp>Menu\TxMax Then Menu\TxMax=tmp

	Menu\nbItem = Menu\nbItem +1
	
	Return Handle(item)
End Function

; -----------------------------------------
; Gestion de la barre de menus
; -----------------------------------------
Function BCF_RenderTitleMenu()

	
	If BCF_Menu=False And BCF_MenuPopuACtif=False Then Return True

	
	If BCF_Menu Then
		; -------------------------------------------------------
		; On trace la barre horizontale des menus
		; -------------------------------------------------------
		BCF_Draw3dBar(0,0,GraphicsWidth(),20,1,BCF_GetRed(Bcf_Color09),BCF_GetGreen(Bcf_Color09), BCF_GetBlue(Bcf_Color09))

		; ---------------------------
		; On teste les menus
		; ---------------------------
		For Menu.TMenu=Each TMenu
		
			Select Menu\TypeMenu
				Case BCF_MenuMenu
					If BCF_Move3DMouse( Menu\Px , 4 ,Menu\tx  , 15 ) Then
						; --------------------------------
						; Avons change de menu
						; --------------------------------
 						If (BCF_Move3DMouse(Menu\Px , 4 ,Menu\tx  ,15,True) Or BCF_MenuActif) And BCF_MenuPopUpActif=False  Then
					
							BCF_CloseAllMenu()
							
							If  Menu\Enabled Then
								BCF_OpenSubMenu( Handle( Menu)  )
							EndIf
							
						EndIf

						; ----------------------------------------------------------------
						; On trace le cadre de l'item de la barre de menu
						; ----------------------------------------------------------------
						If BCF_WindowMove = False And BCF_Requester = False Then
							BCF_Draw3dBar(Menu\Px-4,1,Menu\tx+6,18,2,BCF_GetRed(Bcf_Color09),BCF_GetGreen(Bcf_Color09), BCF_GetBlue(Bcf_Color09))

							; -------------------------------------------
							; Definition de la couleur du texte
							; -------------------------------------------
							SetFont  BCF_InterfaceFont : Color 0,0,0
						Else
							SetFont  BCF_InterfaceFont : Color BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03)
						EndIf
						
					Else
						SetFont  BCF_InterfaceFont : Color BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03)
					EndIf

					; -------------------------------------------------------
					; Si les items des menus sont desactivés
					; -------------------------------------------------------
					If  Not Menu\Enabled  Then
						Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
					EndIf

					; -----------------------------------------------------
					; Texte des items de la barre horizontale
					; -----------------------------------------------------
					Text Menu\Px, 3 , Menu\label$
					
				Case BCF_MenuSubMenu
					If  BCF_MouseOnMenu( ) Then
							If Not BCF_MouseInMenu( Handle(Menu) ) Then
								Highlighting=False
								For Item.TMenuItem = Each TMenuItem
									If  Item\hParent = Handle(menu) Then
										If  Item\highlights Then
											Highlighting = True
										EndIf
									EndIf
								Next

							If  Not Highlighting Then
								Menu\Open = False
								Item.TMenuItem = Object.TMenuItem( Menu\hItemChild )
								Item\highlights = False
							EndIf
						EndIf
					EndIf
			End Select
		Next

		; -----------------------------
		; Affichage des menus
		; -----------------------------
		For  Menu.TMenu = Each TMenu
			If menu\open Then
				BCF_RenderMenu(Handle(menu), Menu\Py)
			EndIf
		Next
		
	EndIf
	
End Function

; -----------------------------------------------------------
; Gestion des menus de la barre des menus
; -----------------------------------------------------------
Function BCF_RenderMenu(hMenu, Py , Px=-1)
	Local bChildMenu

	Menu.TMenu = Object.TMenu( hMenu)

	If Px>-1 Then Menu\Px= Px
		BCF_MenuActif = True
	
		SetFont  BCF_InterfaceFont
	
		If Menu\nbItem>0 Then
			BCF_Draw3dBar(Menu\Px-3,Py, Menu\TxMax + 50 , (Menu\NbItem) * (FontHeight()+4) ,1,BCF_GetRed(Bcf_Color09),BCF_GetGreen(Bcf_Color09), BCF_GetBlue(Bcf_Color09))

			Py = Py +   FontHeight()/3
			For Item.TMenuItem = Each TMenuItem

				If Item\hParent = hMenu Then
					If Item\TypeItem <>BCF_MenuItemSeparator Then
						If  Item\visible Then

							; --------------------------------------------------
							; Sommes nous sur un item du menu
							; --------------------------------------------------
							If BCF_Move3DMouse(Menu\Px -3, Py ,Menu\TxMax + 50-8  ,FontHeight() + 2) Then
	
							; ----------------------------------------------------------------
							; On affiche le rectangle autour de texte de l'item
							; ----------------------------------------------------------------
							If Item\enabled Then
								BCF_DrawGradientBar(Menu\Px-2,Py -(FontHeight()/2-3),Menu\TxMax + 48,FontHeight() + 2,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02),BCF_GetRed(Bcf_Color04),BCF_GetGreen(Bcf_Color04), BCF_GetBlue(Bcf_Color04),1)

								Color BCF_GetRed(Bcf_Color04),BCF_GetGreen(Bcf_Color04), BCF_GetBlue(Bcf_Color04)
								Rect Menu\Px-2,Py -(FontHeight()/2-3),Menu\TxMax + 49,FontHeight() + 2,0
							EndIf

							; -------------------------------------
							; Couleur du texte des items
							; -------------------------------------
							Color BCF_GetRed(Bcf_Color08),BCF_GetGreen(Bcf_Color08), BCF_GetBlue(Bcf_Color08)

							; -------------------------------------------
							; Test d'ouverture du sous menu
							; -------------------------------------------
							If  Item\typeItem = BCF_MenuItemSubMenu Then
								BCF_OpenSubMenu( Item\hsubMenu, (Menu\Px-4) + Menu\TxMax + 50 - 8 , Py -(FontHeight()/2-4) )
							Else
								If BCF_MouseRelease_L Then
									Item\Selected=True
									BCF_MenuSelection = True
								EndIf
									
							EndIf			
						Else
							; ------------------------------------------------------------------
							; Si le menu est actif mais que l'on sort de la zone
							; ------------------------------------------------------------------
							If Item\highlights Then
								BCF_DrawGradientBar(Menu\Px-2,Py -(FontHeight()/2-3),Menu\TxMax + 48,FontHeight() + 2,BCF_GetRed(Bcf_Color02),BCF_GetGreen(Bcf_Color02), BCF_GetBlue(Bcf_Color02),BCF_GetRed(Bcf_Color04),BCF_GetGreen(Bcf_Color04), BCF_GetBlue(Bcf_Color04),1)

								Color BCF_GetRed(Bcf_Color04),BCF_GetGreen(Bcf_Color04), BCF_GetBlue(Bcf_Color04)
								Rect Menu\Px-2,Py -(FontHeight()/2-3),Menu\TxMax + 49,FontHeight() + 2,0
								
								; -------------------------------------
								; Couleur du texte des items
								; -------------------------------------
								Color BCF_GetRed(Bcf_Color00),BCF_GetGreen(Bcf_Color00), BCF_GetBlue(Bcf_Color00)
							Else
								Color BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03)
							EndIf
						EndIf

						; -------------------------------------------------------------
						; Selection de la couleur si item pas desactive
						; -------------------------------------------------------------
						If Item\enabled=False Then
							Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
						EndIf

						; --------------------------------------
						; Affichage du texte des items
						; --------------------------------------
						Text Menu\Px+4, Py-2 , Item\label$

						; -------------------------------------------------------------------------------
						; On place un symbole sur l'item pointe vers un sous menu
						; -------------------------------------------------------------------------------
						If  Item\typeItem = BCF_MenuItemSubMenu  Then
							DrawImage Item\ImgSubMark,(Menu\Px-4) + Menu\TxMax + 50 - 19 ,Py-2
						EndIf
						
						Py = Py + FontHeight() + 4
					EndIf
				Else
					BCF_Draw3dBar(Menu\Px+4,Py -2 +FontHeight()/2 ,(Menu\Px-4) + (Menu\TxMax-Menu\Px) + 38 ,1,2,BCF_GetRed(Bcf_Color09),BCF_GetGreen(Bcf_Color09), BCF_GetBlue(Bcf_Color09))
					
					Py = Py + FontHeight() + 4
				EndIf
			EndIf
		Next
	EndIf
End Function

; -------------------------------------
; Gestion des menus popup
; -------------------------------------
Function BCF_RenderPopUpMenu()

	
	If BCF_WindowMove Or BCF_Requester Then Return True
	
	If BCF_MenuPopUpCurrent<> BCF_MenuNoPopup And BCF_MenuPopUpActif Then	
		If (BCF_Move3DMouse( BCF_MenuPopUpPx , BCF_MenuPopUpPy ,BCF_MenuPopUpTx  , BCF_MenuPopUpTy ))  Then
			menu.TMenu = Object.TMenu( BCF_MenuPopUpCurrent)

			For  Menu.TMenu = Each TMenu
				If Menu\TypeMenu = BCF_MenuSubMenu Then
					If  BCF_MouseOnMenu( ) Then
						If Not BCF_MouseInMenu( Handle(Menu) ) Then
							Highlighting=False
							For Item.TMenuItem = Each TMenuItem
								If  Item\hParent = Handle(menu) Then
									If  Item\highlights Then
										Highlighting = True
									EndIf
								EndIf
							Next

							If  Not Highlighting Then
								Menu\Open = False
								Item.TMenuItem = Object.TMenuItem( Menu\hItemChild )
								Item\highlights = False
							EndIf
						EndIf
					EndIf
				EndIf
				
				For pMenu.TMenu =Each TMenu
					If pmenu\open Then
						BCF_RenderMenu(Handle(pmenu), pMenu\Py , pMenu\Px )
					EndIf
				Next
			Next
		EndIf
	Else
		BCF_MenuPopUpActif=False
	EndIf
End Function

; -----------------------------------------------------------------------------------
; Determine quel menu popup sera affiche lors du clique droit
; -----------------------------------------------------------------------------------
Function BCF_SetPopupMenu( hMenu,Px=-1,Py=-1,tx=-1 , ty=-1 )
	If Px+Py+tx+ty<0 Then
		BCF_MenuPopUpPx=0
		
		If BCF_Menu Then
			BCF_MenuPopUpPy=21
		Else
			BCF_MenuPopUpPx=0
		EndIf
		
		BCF_MenuPopUpTx=GraphicsWidth()
		BCF_MenuPopUpTy=GraphicsHeight()
	Else
		BCF_MenuPopUpPx = Px
 		BCF_MenuPopUpPy = Py
 		BCF_MenuPopUpTx = tx
 		BCF_MenuPopUpTy = ty
	EndIf

	BCF_MenuPopUpCurrent = hMenu
End Function 

; ------------------------------------
; Intialise le popup courrant
; ------------------------------------
Function BCF_MenuActivatePopUp()

	If BCF_MenuPopUpActif Then BCF_CloseAllMenu()
	
	BCF_MenuPopUpActif=True

	If BCF_MenuPopUpCurrent <> BCF_MenuNoPopup Then
		
		menu.TMenu = Object.TMenu( BCF_MenuPopUpCurrent)
		If Not bOpen Then
			Menu\Px = MouseX()
			Menu\Py = MouseY()
			Menu\open = True
		EndIf
	EndIf
	
End Function

; ------------------------------------------
; Prepare un menu a etre ouvert
; ------------------------------------------
Function BCF_OpenSubMenu( id , Px =-1, Py=-1 )
	Menu.TMenu = Object.TMenu( id )

	Menu\open=True
	If Px>-1 Then Menu\Px = Px
	If Py>-1 Then Menu\Py = Py

	If Menu\typemenu = BCF_MenuSubMenu Then
		Itemchild.TMenuItem = Object.TMenuItem( Menu\hItemChild )
		ItemChild\highlights =True
	EndIf
End Function

; ---------------------------------------------------------------------------------------
; Initialise la fermeture de tous les menus quelques soit leur type
; ----------------------------------------------------------------------------------------
Function BCF_CloseAllMenu()
	For Menu.TMenu = Each TMenu
		Menu\Open=False
	Next
End Function

; ----------------------------------------------------------------------
; Indique si la souris se trouve dans un menu precis
; ----------------------------------------------------------------------
Function BCF_MouseInMenu( hMenu )
	Menu.Tmenu = Object.Tmenu( hMenu )

	If BCF_Move3DMouse(Menu\Px-4,Menu\Py, Menu\TxMax + 50 ,  (Menu\NbItem) * (FontHeight()+5) )  Then
		Return True
	Else
		Return False
	EndIf
End Function

; -------------------------------------------------------------------
; Indique si la souris se trouve sur un menu precis
; -------------------------------------------------------------------
Function BCF_MouseOnMenu( )
	bRetour= False
	SetFont  BCF_InterfaceFont
	
	For Menu.TMenu=Each TMenu
		If Menu\open Then
			If BCF_Move3DMouse(Menu\Px-4,Menu\Py, Menu\TxMax + 50 ,  (Menu\NbItem) * (FontHeight()+5) )  Then
				bRetour = True
			EndIf
		EndIf
	Next

	Return bRetour
End Function

; ---------------------
; Active un menu
; ---------------------
Function BCF_EnableMenu( hMenu )
	Menu.TMenu = Object.TMenu( hMenu )
	Menu\enabled=True	
End Function

; ---------------------------
; Desactive un menu
; ---------------------------
Function BCF_DisableMenu( hMenu )
	Menu.TMenu = Object.TMenu( hMenu )
	Menu\enabled=False
End Function

; -----------------------------------------
; Rend visible un Item de menu
; -----------------------------------------
Function BCF_ShowMenuItem( hItem )
	Item.TMenuItem = Object.TMenuItem( hItem )
	Item\visible  = True
End Function

; -----------------------------------
; Cache un Item de menus
; -----------------------------------
Function BCF_HideMenuItem( hItem )
	Item.TMenuItem = Object.TMenuItem( hItem )
	Item\visible  = False
End Function

; --------------------------------
; Active un Item de menu
; --------------------------------
Function BCF_EnableMenuItem (  hItem )
	Item.TMenuItem = Object.TMenuItem( hItem )
	Item\enabled = True
End Function

; --------------------------------------
; Desactive un Item de menu
; --------------------------------------
Function BCF_DisableMenuItem (  hItem )
	Item.TMenuItem = Object.TMenuItem( hItem )
	Item\enabled = False
End Function

; ----------------------------------------------------
; Test un Item pour savoir il a ete clique
; ----------------------------------------------------
Function BCF_TestMenuItem( hItem )
	Item.TMenuItem = Object.TMenuItem( hItem)

	If  Item\selected Then
		Item\selected = False
		Return True
	Else
		Return False
	EndIf
End Function

; ----------------------------------------------------
; Libere la memoire de tous les menus
; ----------------------------------------------------
Function BCF_FreeMenu( )
	For  Menu.TMenu = Each TMenu
		Delete Menu
	Next

	For Item.TMenuItem = Each TMenuItem
		FreeImage Item\ImgSubMark
		Delete Item
	Next

	; ---------------------------------------------
	; Global et constantes des menus
	; ---------------------------------------------
	BCF_Menu = False						; Indique si la gestion des menus fixes est actif ou non
	BCF_MenuActif = False					; indique si le menu est en cours d'utilisation
	BCF_MenuPopUpActif = False		; Indique si un popup menu est en cours d'utilisation
	BCF_MenuPopUpCurrent=-1			; Contient l'Id du popup a afficher
	BCF_MenuSelection = False
	
	BCF_MenuPopUpPx	=0				; position X,Y et Taill X,Y
	BCF_MenuPopUpPy	=0				; ou le click droit permettra d'afficher le popup
	BCF_MenuPopUpTx	=0						
	BCF_MenuPopUpTy	=0						

	BCF_MenuNextx=0						; Permet le positionnement de titre de menus dans la barre de menu
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ---------------------------------------------------------------------------------------------------------
; Function d'innitialisation et d'affichage de pointeur de souris sur un ecran 3D
; ---------------------------------------------------------------------------------------------------------
Function BCF_Init3DMouse(Style=1)
	BCF_MouseStyle=Style
	BCF_MousePointer=BCF_ReadRawImage(BCF_MouseStyle)
	BCF_MouseFlag=1
End Function

; ------------------------------------------
; Permet l'affichage de la souris
; ------------------------------------------
Function BCF_RenderMouse()

	BCF_MouseZSpeed = MouseZSpeed()

	; -----------------------------------------
	; Capture de la position du click
	; -----------------------------------------
	If MouseDown(1) And BCF_MouseClicked_X=-1 Then
		BCF_MouseRealClick_L=True
		BCF_MouseClicked_X = MouseX()
		BCF_MouseClicked_Y = MouseY()
	Else
		BCF_MouseRealClick_L=False
	EndIf

	If MouseDown(2) And BCF_MouseClicked_XR=-1 Then
		BCF_MouseRealClick_R=True
		BCF_MouseClicked_XR = MouseX()
		BCF_MouseClicked_YR = MouseY()
	Else
		BCF_MouseRealClick_R=False
	EndIf
	
	; -------------------------------------
	; Gestion de cliquer relacher
	; -------------------------------------
	BCF_MouseOld_L = BCF_MouseClicked_L
	BCF_MouseClicked_L=MouseDown(1)

	If BCF_MouseOld_L And  BCF_MouseClicked_L=False Then
		BCF_MouseRelease_L=True
	Else 
		BCF_MouseRelease_L=False
	EndIf


	BCF_MouseOld_R = BCF_MouseClicked_R
	BCF_MouseClicked_R=MouseDown(2)

	If BCF_MouseOld_R And  BCF_MouseClicked_R=False Then
		BCF_MouseRelease_R=True
	Else 
		BCF_MouseRelease_R=False
	EndIf
	
	; ----------------------------------------
	; On reinitialise le buffer souris
	; ----------------------------------------
	If BCF_MouseOld_L=False Then
		BCF_MouseClicked_X=-1 
		BCF_WindowMove = False
	Else
		FlushMouse
	EndIf


	If BCF_MouseOld_R=False Then
		BCF_MouseClicked_XR=-1 
	Else
		FlushMouse
	EndIf
	
	; -------------------------------------------------
	; on ferme la combo box au click droit
	; -------------------------------------------------
	If BCF_MouseRealClick_R Then
		BCF_TestCloseComboBox()
		If Not BCF_MenuPopUpActif Then
			BCF_CloseAllMenu()
		EndIf
		BCF_MenuActivatePopUp()
	EndIf
	
	; -----------------------------------------------
	; Gestion de l'affichage de la souris
	; -----------------------------------------------
	BCF_MouseX = MouseX()
	BCF_MouseY = MouseY()
	
	If BCF_MouseFlag=1 Then
		BCF_Draw3DMouse()
	EndIf
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; -------------------------------------------------------
; Creation de barre 3D de differents styles
; -------------------------------------------------------
Function BCF_Draw3dBar(Px,Py,Tx,Ty,Style,Red,Green,Blue)
	Local ImageBar

	; -----------
	; Normal
	; -----------
	If Style=1 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
		
		Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty

		Color BCF_GetRed(Bcf_Color05),BCF_GetGreen(Bcf_Color05), BCF_GetBlue(Bcf_Color05)
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf
	
	; ------------
	; Emboss
	; ------------
	If Style=2 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
		
		Color BCF_GetRed(Bcf_Color05),BCF_GetGreen(Bcf_Color05), BCF_GetBlue(Bcf_Color05)
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty

		Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf	
	
	; --------------------------------------
	; Normal gradient horizontal
	; --------------------------------------
	If Style=3 Then
		BCF_DrawGradientBar(Px,Py,Tx,Ty,Red/3,Green/3,Blue/3,Red,Green,Blue,0)

		Color Red/3,Green/3,Blue/3
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty
	
		Color Red,Green,Blue
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf
	
	; ---------------------------------
	; Normal gradient vertical
	; ---------------------------------
	If Style=4 Then
		BCF_DrawGradientBar(Px,Py,Tx,Ty,Red/3,Green/3,Blue/3,Red,Green,Blue,1)

		Color Red/3,Green/3,Blue/3
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty
	
		Color Red,Green,Blue
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf
	
	; ---------------------------------------
	; Style Applat pour les ListBox
	; ---------------------------------------
	If Style=5 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
	EndIf

	; -------------------------------------------------------
	; Style Applat True Color pour les Gauges  A VIRER
	; -------------------------------------------------------
	If Style=6 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
	EndIf

	; -----------------------------------------------------
	; Style Applat + contour pour les Gauges
	; -----------------------------------------------------
	If Style=7 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
		
		Color Red/2,Green/2,Blue/2
		Rect Px+1,Py+1,Tx-2,Ty-2,1
	EndIf
End Function

; ---------------------------------------------------------------------------------------------------------------------
; Permet d'ecrire créer un cadre 3D en draw + bitmap avec buffer de destination ou non
; ---------------------------------------------------------------------------------------------------------------------
Function BCF_Draw3dBarBitmap(Px,Py,Tx,Ty,Style,ImageNumber=0,ImageDest=0)
	Local BCF_TmpReturn=0
	
	; ---------------------------------------------------------------
	; Si pas d'image de destination on en créer une
	; ---------------------------------------------------------------
	If ImageDest=0 Then
		ImageDest=CreateImage(Tx+2,Ty+2)
		BCF_TmpReturn=1
	EndIf
	
	; ----------------------------------------------------------------------------------------------------------
	; Style 3d normal + image de fond pour les barre de titre des fenetres et bouton
	; ----------------------------------------------------------------------------------------------------------
	If Style=1 Then
		ImageBar=BCF_ReadRawImage(ImageNumber)

		BCF_TmpImg=BCF_ScaleImageFast(ImageBar,Tx+2,Ty+2)
		;ResizeImage ImageBar,Tx+2,Ty+2 :

		SetBuffer ImageBuffer(ImageDest)
	
		CopyRect Px,Py,Tx,Ty,Px,Py,ImageBuffer(BCF_TmpImg),ImageBuffer(ImageDest)
		FreeImage ImageBar : FreeImage BCF_TmpImg
	
		Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty

		Color BCF_GetRed(Bcf_Color05),BCF_GetGreen(Bcf_Color05), BCF_GetBlue(Bcf_Color05)
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf

	; ------------------------------------------------------------------------------------------------------------
	; Style 3D enfonce + image de fond pour les barre de titre des fenetres et bouton
	; ------------------------------------------------------------------------------------------------------------
	If Style=2 Then
		ImageBar=BCF_ReadRawImage(ImageNumber)

		BCF_TmpImg=BCF_ScaleImageFast(ImageBar,Tx+2,Ty+2)
		;ResizeImage ImageBar,Tx+2,Ty+2 :

		SetBuffer ImageBuffer(ImageDest)
	
		CopyRect Px,Py,Tx,Ty,Px,Py,ImageBuffer(BCF_TmpImg),ImageBuffer(ImageDest)
		FreeImage ImageBar : FreeImage BCF_TmpImg
		
		Color BCF_GetRed(Bcf_Color05),BCF_GetGreen(Bcf_Color05), BCF_GetBlue(Bcf_Color05)
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty
	
		Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf

	; ----------------------------------------------------------------------------------------------------------------
	; Style Applat + image de fond pour les barre de titre des fenetres et bouton enfonce
	; ----------------------------------------------------------------------------------------------------------------
	If Style=3 Then
		ImageBar=BCF_ReadRawImage(ImageNumber)

		BCF_TmpImg=BCF_ScaleImageFast(ImageBar,Tx,Ty)
		;ResizeImage ImageBar,Tx+2,Ty+2 :

		SetBuffer ImageBuffer(ImageDest)
	
		CopyRect Px,Py,Tx,Ty,Px,Py,ImageBuffer(BCF_TmpImg),ImageBuffer(ImageDest)
		FreeImage ImageBar : FreeImage BCF_TmpImg

		Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
		Rect Px,Py,Tx,Ty+1,0
	EndIf

	; --------------------------------------------------------------------------------------------------
	; Style Applat sans bordure + image de fond pour les bouton ou checkbox
	; --------------------------------------------------------------------------------------------------
	If Style=4 Then
		ImageBar=BCF_ReadRawImage(ImageNumber)

		SetBuffer ImageBuffer(ImageDest)
	
		CopyRect Px,Py,Tx,Ty,Px,Py,ImageBuffer(ImageBar),ImageBuffer(ImageDest)
		FreeImage ImageBar
	EndIf
	
	; ---------------------------------------------------------------------------------------------
	; Si une image n'avait pas été specifié on retourne l'image temporaire
	; ---------------------------------------------------------------------------------------------
	If BCF_TmpReturn=1 Then
		SetBuffer BackBuffer()
		Return ImageDest
	EndIf 
End Function 

; -------------------------------------------------------------------------
; Permet de créer des boites 3D sous la forme d'image
; -------------------------------------------------------------------------
Function BCF_Make3dBarImage(Px,Py,Tx,Ty,Style,Red,Green,Blue)
	Px=0 : Py=0
	
	BCF_TmpImage=CreateImage(Tx+1,Ty+1)
	SetBuffer ImageBuffer( BCF_TmpImage )
	
	; -----------
	; Normal
	; -----------
	If Style=1 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
		
		Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty

		Color BCF_GetRed(Bcf_Color05),BCF_GetGreen(Bcf_Color05), BCF_GetBlue(Bcf_Color05)
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf
	
	; ------------
	; Emboss
	; ------------
	If Style=2 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
		
		Color BCF_GetRed(Bcf_Color05),BCF_GetGreen(Bcf_Color05), BCF_GetBlue(Bcf_Color05)
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty

		Color BCF_GetRed(Bcf_Color06),BCF_GetGreen(Bcf_Color06), BCF_GetBlue(Bcf_Color06)
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf	
	
	; --------------------------------------
	; Normal gradient horizontal
	; --------------------------------------
	If Style=3 Then
		BCF_DrawGradientBar(Px,Py,Tx,Ty,Red/3,Green/3,Blue/3,Red,Green,Blue,0)

		Color Red/3,Green/3,Blue/3
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty
	
		Color Red,Green,Blue
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf
	
	; ---------------------------------
	; Normal gradient vertical
	; ---------------------------------
	If Style=4 Then
		BCF_DrawGradientBar(Px,Py,Tx,Ty,Red/3,Green/3,Blue/3,Red,Green,Blue,1)

		Color Red/3,Green/3,Blue/3
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty
	
		Color Red,Green,Blue
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf
	
	; ---------------------------------------
	; Style Applat pour les ListBox
	; ---------------------------------------
	If Style=5 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
	EndIf

	; -------------------------------------------------------
	; Style Applat True Color pour les Gauges  A VIRER
	; -------------------------------------------------------
	If Style=6 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
	EndIf

	; -----------------------------------------------------
	; Style Applat + contour pour les Gauges
	; -----------------------------------------------------
	If Style=7 Then
		Color Red,Green,Blue
		Rect Px,Py,Tx,Ty,1
		
		Color Red/2,Green/2,Blue/2
		Rect Px+1,Py+1,Tx-2,Ty-2,1
	EndIf

	; -------------------------------------------------------
	; Style 3D mais fond noir pour les images
	; -------------------------------------------------------
	If Style=8 Then
		Color 0,0,0
		Rect Px,Py,Tx,Ty,1

		Color Red,Green,Blue
		Line Px+Tx,Py,Px+Tx,Py+Ty
		Line Px,Py+Ty,Px+Tx,Py+Ty
	
		Color Red/3,Green/3,Blue/3
		Line Px,Py,Px+Tx,Py	
		Line Px,Py,Px,Py+Ty	
	EndIf	
	
	SetBuffer BackBuffer()
	Return BCF_TmpImage
End Function

; -----------------------------------------
; Creation de barre de degrade
; -----------------------------------------
Function BCF_DrawGradientBar(Px,Py,Tx,Ty,StartRed#,StartGreen#,StartBlue#,EndRed#,EndGreen#,EndBlue#,Dir=0)
	If Dir=0
		Direction=Tx
		Temp_X=Px
		Temp_Y=Tx
	Else
		Direction=Ty
		Temp_X=Py
		Temp_Y=Ty
	EndIf
	
	GradientRed#=(EndRed-StartRed)/Direction
	GradientGreen#=(EndGreen-StartGreen)/Direction
	GradientBlue#=(EndBlue-StartBlue)/Direction

	For Grad=Temp_X To Temp_X+Temp_Y
		Color StartRed,StartGreen,StartBlue
		
		If Dir=0
			Line Grad,Py,Grad,Py+Ty
		Else
			Line Px,Grad,Px+Tx,Grad
		EndIf
		
		StartRed=StartRed+GradientRed
		StartGreen=StartGreen+GradientGreen
		StartBlue=StartBlue+GradientBlue
	Next
End Function

; ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

; ---------------------------------------------------------------
; Pour créer des requesters Ok,Oui,Non,Cancel
; ---------------------------------------------------------------
Function BCF_MsgBox(Title$,Message$,RequestType=0,IconNumber=1)
	BCF_TestCloseComboBox()

	BCF_HalfWIdth=GraphicsWidth()/2
	BCF_HalfHeight=GraphicsHeight()/2

	; ---------------------------------------------------------
	; Si une icone on definit un rajout a gauche
	; ---------------------------------------------------------
	If  IconNumber>0 Then 
		BCF_RequestBorder=45
	Else
		BCF_RequestBorder=10
	EndIf 
	
	; ------------------------------------------------------
	; Si le titre est plus long que le message
	; ------------------------------------------------------
	If Len(Title$)>Len(Message$) Then
		BCF_RequestWIdth=StringWidth(Title$)+BCF_RequestBorder+10
	Else
		BCF_RequestWIdth=StringWidth(Message$)+BCF_RequestBorder+10
	EndIf

	; ----------------------------------------------------------------------------
	; Si la largeur du requester est inferieur a un seuil donné
	; ----------------------------------------------------------------------------
	If BCF_RequestWIdth<130 Then
		BCF_RequestWIdth=130
	EndIf
	
	BCF_RequestHeight=110	
	BCF_ButtonTx=60

	; -----------------------------------------------------------
	; Definition de la position X et Y du requester
	; -----------------------------------------------------------
	BCF_Px=BCF_HalfWIdth-(BCF_RequestWIdth/2)
	BCF_Py=BCF_HalfHeight-(BCF_RequestHeight/2)
	
	Requester=BCF_CreateWindow(BCF_Px,BCF_Py,BCF_RequestWIdth,BCF_RequestHeight,BCF_GuiStyle,6,Title$,True,False)
	
	; ------------------------------------------
	; Selection du type de requester
	; ------------------------------------------
	Select RequestType
	Case 0
		BCF_Ok=BCF_CreateButton(Requester,BCF_RequestWIdth/2-(BCF_ButtonTx/2)-2,BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxOk$,BCF_GuiStyle)
	Case 1
		BCF_Yes=BCF_CreateButton(Requester,10,BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxYes$,BCF_GuiStyle)
		BCF_No=BCF_CreateButton(Requester,BCF_RequestWIdth-(BCF_ButtonTx+14),BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxNo$,BCF_GuiStyle)
	Case 2
		BCF_Yes=BCF_CreateButton(Requester,10,BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxYes$,BCF_GuiStyle)
		BCF_No=BCF_CreateButton(Requester,BCF_RequestWIdth/2-(BCF_ButtonTx/2+2),BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxNo$,BCF_GuiStyle)
		BCF_Cancel=BCF_CreateButton(Requester,BCF_RequestWIdth-(BCF_ButtonTx+14),BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxCancel$,BCF_GuiStyle)
	End Select

	; ---------------------------------------------
	; Affichage du label text et de l'icon
	; ---------------------------------------------
	Select IconNumber
	Case 1
		BCF_RequesterIcon=BCF_CreateIcon(Requester,5,6,5000,0)
	Case 2
		BCF_RequesterIcon=BCF_CreateIcon(Requester,5,6,5001,0)
	Case 3
		BCF_RequesterIcon=BCF_CreateIcon(Requester,5,6,5002,0)
	End Select
	
	BCF_CreateLabelText(Requester,BCF_RequestBorder,20,Message$,1,1 ,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))

	; ----------------------------------------------------------
	; On bloque la selection des autres fenêtres
	; ----------------------------------------------------------
	BCF_Requester = True
	BCF_RequestReturn=-1
	
	While  BCF_RequestReturn=-1
		If BCF_TestButton(BCF_Ok) Then
			BCF_RequestReturn=0
		EndIf
				
		If BCF_TestButton(BCF_Yes) Then
			BCF_RequestReturn=1
		EndIf

		If BCF_TestButton(BCF_No) Then
			BCF_RequestReturn=2
		EndIf
	
		If BCF_TestButton(BCF_Cancel)  Then
			BCF_RequestReturn=3
		EndIf

		UpdateWorld
		RenderWorld
		
		; -------------------------------------------
		; Rafraichissement de l'interface
		; -------------------------------------------
		BCF_RenderBCF()

		Flip False
	Wend

	; ------------------------------
	; On efface les gadgets
	; ------------------------------
	BCF_KillWindow(Requester)
	BCF_Requester=False
	
	Return BCF_RequestReturn
End Function

; --------------------------------------------------------------------------------------
; Pour créer des requesters ValIder, Annuler avec zone de saisie
; --------------------------------------------------------------------------------------
Function BCF_MsgInputBox$(Title$,Label$="")
	HalfWIdth=GraphicsWidth()/2
	HalfHeight=GraphicsHeight()/2
	
	; --------------------------------------------------------------------------------------------------------
	; Definition de la taille Tx et Ty de l'inputBox ainsi que la longueur des boutons
	; --------------------------------------------------------------------------------------------------------
	BCF_RequestWIdth=435
	BCF_RequestHeight=100
	
	BCF_ButtonTx=60
	
	; -----------------------------------------------------------
	; Definition de la position X et Y du requester
	; -----------------------------------------------------------
	BCF_Px=HalfWIdth-(BCF_RequestWIdth/2)
	BCF_Py=HalfHeight-(BCF_RequestHeight/2)
	
	; ------------------------------------------
	; Creation du body du requester
	; ------------------------------------------
	Requester=BCF_CreateWindow(BCF_Px,BCF_Py,BCF_RequestWIdth,BCF_RequestHeight,BCF_GuiStyle,3,Title$,True,False)
	
	BCF_Continue=BCF_CreateButton(Requester,10,BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxOk$,BCF_GuiStyle)
	BCF_Clear=BCF_CreateButton(Requester,BCF_RequestWIdth/2-(BCF_ButtonTx/2),BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxClear$ ,BCF_GuiStyle)
	BCF_Cancel=BCF_CreateButton(Requester,BCF_RequestWIdth-(BCF_ButtonTx+14),BCF_RequestHeight-55,BCF_ButtonTx,20,BCF_MsgBoxCancel$,BCF_GuiStyle)
	BCF_MyInputBox=BCF_CreateInputBox(Requester,10,15,Label$,255,False,1,50)

	; ---------------------------------------------
	; Sauvegarde de l'ancienne valeur
	; ---------------------------------------------
	BCF_OldInputBox$=BCF_TestInputBox$(BCF_MyInputBox)

	; -----------------------------------------------------------
	; On bloque la selection des autres fenêtres
	; -----------------------------------------------------------
	BCF_Requester = True
	BCF_RequestReturn=-1
	
	; -------------------------
	; Boucle de gestion
 	; -------------------------
	FlushKeys
	
	While  BCF_RequestReturn=-1
		If BCF_TestButton(BCF_Continue) Then
			RequestReturn$=BCF_TestInputBox$(BCF_MyInputBox)
			BCF_RequestReturn=True
		EndIf
				
		If BCF_TestButton(BCF_Cancel) Then
			RequestReturn$=BCF_OldInputBox$
			BCF_RequestReturn=True
		EndIf

		If BCF_TestButton(BCF_Clear)  Then
			BCF_ChangeInputBoxLabel(BCF_MyInputBox,"")
		EndIf
	
		UpdateWorld		
		RenderWorld
		
		; -------------------------------------------
		; Rafraichissement de l'interface
		; -------------------------------------------
		BCF_RenderBCF()
	
		Flip	False
	Wend
	
	; ------------------------------
	; On efface les gadgets
	; ------------------------------
	BCF_KillWindow(Requester)
	BCF_Requester=False

	Return RequestReturn$
End Function

; ---------------------------------------------------------------------------------------
; Permet de savoir si une fenetre est ouverte retour True ou False
; ---------------------------------------------------------------------------------------
Function BCF_Window( Id , active=False )

	bRetour = False
		
	BCF.TWindow = Object.TWindow (Id)
	If (BCF <> Null)
			bRetour=True
			If active Then
				If BCF\Active Then
					bRetour=True
				Else
					bRetour=False
				EndIf
			EndIf
	EndIf

	Return bRetour
End Function

; -------------------------------------------------------------------------------------------
; Permet de tester si une fenetre est activé (Retour TRUE ou FALSE)
; -------------------------------------------------------------------------------------------
Function BCF_WindowIsActive(Id)
	BCF.TWindow = Object.TWindow (Id)
	If (BCF <> Null)
		Return BCF\Active
	EndIf 
End Function

; ---------------------------------------------
; Fonction pour afficher le pointeur
; --------------------------------------------- 
Function BCF_Draw3DMouse()
	DrawImage BCF_MousePointer,MouseX(),MouseY()
End Function

; ----------------------------------------------------------------------------------------
; Fonction pour detecter si la souris bouge dans une zone donnée
; ----------------------------------------------------------------------------------------
Function BCF_Move3DMouse( Px , Py ,Tx , Ty, clicked=False )
	bRetour = False
	
	If MouseX() >=Px  And MouseX() <= Px  + Tx  And MouseY()>= Py And MouseY() <=Py + Ty Then
		bRetour =True
	Else
		bRetour= False
	EndIf

	If bRetour And clicked Then
		If BCF_MouseClicked_X >=Px  And BCF_MouseClicked_X <= Px  + Tx  And BCF_MouseClicked_Y>= Py And BCF_MouseClicked_Y <=Py + Ty  Then
			bRetour = True
		Else
			bRetour = False
		End If
	EndIf

	Return bRetour
End Function

; -------------------------------------------------------------------------------------
; Fonction pour detecter si la souris bouge sur une des fenêtres 
; -------------------------------------------------------------------------------------
Function BCF_MouseOnWindows()
			
	For BCF.TWindow = Each TWindow
		If BCF\Id<>BCF_IdVirtualParent Then
			If BCF\State=0 Then
				Tmpheight=BCF\Ty
			Else
				Tmpheight=20
			EndIf
			If BCF_Move3DMouse( BCF\Px , BCF\Py , BCF\Tx , Tmpheight) Then Return True
		EndIf
	Next

	Return False
End Function 

; ---------------------------------------------
; Fonction pour detruire le pointeur
; --------------------------------------------- 
Function BCF_Kill3DMouse()
	FreeImage BCF_MousePointer
	BCF_MouseFlag=0
End Function

; ---------------------------------------------
; Fonction pour centrer le pointeur
; --------------------------------------------- 
Function BCF_Center3DMouse()
	MoveMouse GraphicsWidth()/2,GraphicsHeight()/2 
End Function

; ----------------------------------------------------------------------------------------------------------------------
; Fonction pour switcher le resultat d'un valeur booleene (0/1) pratique pour les boutons
; ----------------------------------------------------------------------------------------------------------------------
Function BCF_Switch(Value)
	Val=1-Value
	Return Val
End Function

; ------------------------------------------------------
; Permet de definir des timer multitaches
; ------------------------------------------------------
Function BCF_SetTimer(TimeOut )
	Timer.TTimer = New TTimer
	Timer\Start   = MilliSecs() 
	Timer\TimeOut = Timer\start + TimeOut
	
	Return Handle(Timer)
End Function

Function BCF_TimeOut (Test)
	Timer.ttimer = Object.Ttimer( Test )	
	
	If Timer <> Null
		If Timer\TimeOut < MilliSecs()
			Delete Timer
			Return True
		Else
			Return False
		EndIf
	Else
		Return True
	EndIf
End Function

; ------------------------------------------------------
; Permet d'afficher un selecteur de fichier
; ------------------------------------------------------
Function BCF_FileRequester$( Title$="",ButtonValidate$="",ButtonCancel$="",ExtList$="",FileReqPath$="",FileReqFile$="")
	Local BCF_TmpExtList$ = ""
	Local BCF_TmpExt$ = ""
	Local BCF_PosExt = 0
	Local Ext$ = ""
	Local NewExt$ = ""

	BCF_HalfWidth=GraphicsWidth()/2
	BCF_HalfHeight=GraphicsHeight()/2
	
	BCF_RequestWidth=550
	BCF_RequestHeight=400

	If Title$="" Then
		Title$=BCF_FileRequestTitle$
	EndIf

	If ButtonValidate$="" Then
		ButtonValidate$=BCF_FileRequestValidate$
	EndIf

	If ButtonCancel$="" Then
		ButtonCancel$=BCF_FileRequestCancel$
	EndIf 
	
	; -----------------------------------------------------------
	; Definition de la position X et Y du requester
	; -----------------------------------------------------------
	BCF_Px=BCF_HalfWIdth-(BCF_RequestWIdth/2)
	BCF_Py=BCF_HalfHeight-(BCF_RequestHeight/2)
	
	; ------------------------------
	; Creation de la fenetre
	; ------------------------------
	FileRequester = BCF_CreateWindow(BCF_Px,BCF_Py, BCF_RequestWIdth,BCF_RequestHeight,BCF_GuiStyle,2,Title$,True,False)

	; --------------------------------------------------------------------------------------------------------
	; Creation de la combobox de choix d'extension et affichage du texte extension
	; --------------------------------------------------------------------------------------------------------
	BCF_CreateLabelText(FileRequester,BCF_RequestWIdth-90,BCF_RequestHeight-95, BCF_FileRequestExt$,1,1,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))
	ComboExtList = BCF_CreateComboBox(FileRequester,BCF_RequestWIdth-90, BCF_RequestHeight-80,75,64)

	; ----------------------------------------------------------------------------------------------------
	; On verifie si la liste des extensions fini bien par un ; et on construit la liste
	; ----------------------------------------------------------------------------------------------------
	If (Len(ExtList$) <= 0)
		ExtList$ = ".*|"
	Else
		If (Mid$(ExtList$,Len(ExtList$),1) <> "|") Then ExtList$ = ExtList$ + "|"
	EndIf
	
	BCF_TmpExtList$ = ExtList$

	; -----------------------------------------------------------------------------------------------------
	; On scane la chaine des extensions de fichier et on les ajoutes a la combo
	; -----------------------------------------------------------------------------------------------------
	Repeat 
		BCF_PosExt = Instr(BCF_tmpExtList$, "|")
		BCF_TmpExt$ = Left$(BCF_tmpExtList$, BCF_PosExt-1) 
		BCF_TmpExtList$ = Mid$(BCF_tmpExtList$, BCF_PosExt+1)
		
		BCF_AddComboBoxItem( comboExtList ,BCF_tmpExt$ ) ; On ajoute l'extension dans la combo
		
		If (Ext$ = "") Then Ext$ = BCF_tmpExt$ ; On sauve la premiere extension, elle sera par defaut
	Until BCF_TmpExtList$ = ""
	
	BCF_SelectedComboBoxValue( comboExtList, Ext$) ; Extension par defaut, la derniere

	; -------------------------------------------------------------
	; Creation de la combobox de choix de lecteur
	; -------------------------------------------------------------
	BCF_CreateLabelText(FileRequester,10,17,BCF_FileRequestDrive$,1,1,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))

	DriveList = BCF_CreateComboBox(FileRequester,110,12,60,145)
	
	BCF_CheckDrive=GetLogicalDrives()

	For i=0 To 25
		BCF_ShiftedData=BCF_CheckDrive Shr i
		BCF_BitValue = BCF_ShiftedData And 1
		
		If BCF_BitValue<>0
			BCF_AddComboBoxItem( DriveList,Str(Chr(65+i))+":" )
			EndIf
	Next

	; ------------------------------------------------------------------------------------------------------------
	; Gestion du path d'ouverture, si le path est vide en prends la directory par defaut
	; ------------------------------------------------------------------------------------------------------------
	If FileReqPath$="" Then
		FileReqPath$ = SystemProperty$("appdir")
		FileReqPath$ = Left$( FileReqPath$ , Len( FileReqPath$)-1 )
	EndIf

	; ----------------------------
	; Extraction du lecteur
	; ----------------------------
	If BCF_bPath=False Then
		BCF_Drive$ = Upper$(Left$( FileReqPath$,2))
		BCF_Old_Drive$ = BCF_Drive$
		BCF_path$ = Mid$(  FileReqPath$,3,256)
		BCF_bPath=True
	EndIf

	BCF_SelectedComboBoxValue( DriveList, Upper$(BCF_Drive$) )

	; -------------------------------------------------
	;Creation du label recuperant le path
	; -------------------------------------------------
	Path_label = BCF_CreateInputBox(FileRequester,180,13,BCF_path$,255,False,1,43)
	
	; --------------------------------------------------
	; Creation de ma listbox des fichiers
	; --------------------------------------------------
	BCF_FileList = BCF_CreateListBox(FileRequester,80,43,BCF_RequestWIdth-95,BCF_RequestHeight-150)
	BCF_FrameDrive=BCF_CreateFrame(FileRequester,11,39,63,BCF_RequestHeight-146,"",3)

	BCF_DriveLabel01 =  BCF_CreateLabelText(FileRequester,38,56,"C:",1,2,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))
	BCF_DriveLabel02 =  BCF_CreateLabelText(FileRequester,38,116,"D:",1,2,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))
	BCF_DriveLabel03 =  BCF_CreateLabelText(FileRequester,38,176,"E:",1,2,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))
	BCF_DriveLabel04 =  BCF_CreateLabelText(FileRequester,38,236,"F:",1,2,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))

	Select BCF_GetDriveType%("C:")
	Case BCF_DriveType_HARDDISK
		BCF_IconDrive01=BCF_CreateIcon (FileRequester,17,53,6000,0)
	Case BCF_DriveType_CDROM
		BCF_IconDrive01=BCF_CreateIcon (FileRequester,17,53,6001,0)
	Case BCF_DriveType_REMOVEABLE
		BCF_IconDrive01=BCF_CreateIcon (FileRequester,17,53,6002,0)
	Case BCF_DriveType_NOTPRESENT
		BCF_IconDrive01=BCF_CreateIcon (FileRequester,17,53,6003,0)
	Default
		BCF_IconDrive01=BCF_CreateIcon (FileRequester,17,53,6000,0)
	End Select

	Select BCF_GetDriveType%("D:")
	Case BCF_DriveType_HARDDISK
		BCF_IconDrive02=BCF_CreateIcon (FileRequester,17,113,6000,0)
	Case BCF_DriveType_CDROM
		BCF_IconDrive02=BCF_CreateIcon (FileRequester,17,113,6001,0)
	Case BCF_DriveType_REMOVEABLE
		BCF_IconDrive02=BCF_CreateIcon (FileRequester,17,113,6002,0)
	Case BCF_DriveType_NOTPRESENT
		BCF_IconDrive03=BCF_CreateIcon (FileRequester,17,173,6003,0)
	Default
		BCF_IconDrive02=BCF_CreateIcon (FileRequester,17,113,6000,0)
	End Select

	Select BCF_GetDriveType%("E:")
	Case BCF_DriveType_HARDDISK
		BCF_IconDrive03=BCF_CreateIcon (FileRequester,17,173,6000,0)
	Case BCF_DriveType_CDROM
		BCF_IconDrive03=BCF_CreateIcon (FileRequester,17,173,6001,0)
	Case BCF_DriveType_REMOVEABLE
		BCF_IconDrive03=BCF_CreateIcon (FileRequester,17,173,6002,0)
	Case BCF_DriveType_NOTPRESENT
		BCF_IconDrive03=BCF_CreateIcon (FileRequester,17,173,6003,0)
	Default
		BCF_IconDrive03=BCF_CreateIcon (FileRequester,17,173,6000,0)
	End Select

	Select BCF_GetDriveType%("F:")
	Case BCF_DriveType_HARDDISK
		BCF_IconDrive04=BCF_CreateIcon (FileRequester,17,233,6000,0)
	Case BCF_DriveType_CDROM
		BCF_IconDrive04=BCF_CreateIcon (FileRequester,17,233,6001,0)
	Case BCF_DriveType_REMOVEABLE
		BCF_IconDrive04=BCF_CreateIcon (FileRequester,17,233,6002,0)
	Case BCF_DriveType_NOTPRESENT
		BCF_IconDrive04=BCF_CreateIcon (FileRequester,17,233,6003,0)
	Default
		BCF_IconDrive04=BCF_CreateIcon (FileRequester,17,233,6000,0)
	End Select
	
	; ---------------------------------------------
	; L'inputbox de saisie ou de retour
	; ---------------------------------------------
	BCF_CreateLabelText(FileRequester,10,BCF_RequestHeight-95,BCF_FileRequestSelected$,1,1,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))
	BCF_InputFile = BCF_CreateInputBox(FileRequester,10,BCF_RequestHeight-80,FileReqFile$,255,False,1,52)

	; ---------------------------------------------------------------
	; Les boutons valider / créer repertoire / annuler
	; ---------------------------------------------------------------
	BCF_Validate = BCF_CreateButton(FileRequester,10,BCF_RequestHeight-50,StringWidth(ButtonValidate$)+20,20,ButtonValidate$,BCF_GuiStyle)
	
	BCF_CreateDir = BCF_CreateButton(FileRequester,BCF_RequestWIdth/2-StringWidth(BCF_FileRequestCreate$)/2-20,BCF_RequestHeight-50,StringWidth(BCF_FileRequestCreate$)+20,20,BCF_FileRequestCreate$,BCF_GuiStyle)

	BCF_Cancel = BCF_CreateButton(FileRequester,BCF_RequestWIdth-StringWidth(ButtonCancel$)-37,BCF_RequestHeight-50,StringWidth(ButtonCancel$)+20,20,ButtonCancel$,BCF_GuiStyle)
	
	; --------------------------------
	; Ouverture du repertoire
	; --------------------------------
	BCF_ReadFolder( BCF_FileList , BCF_Drive$ + BCF_Path$,Ext$,1)

	; -------------------------------------------------------------
	; On bloque la selection des autres fenêtres
	; -------------------------------------------------------------
	BCF_Requester = True		
	BCF_RequestReturn=-1
	BCF_DblClick = 0
	
	While BCF_RequestReturn=-1

		; ------------------------------------------------
		; Si l'utilisateur a clique sur annule
		; ------------------------------------------------
		If BCF_TestButton(BCF_Cancel) Then
			BCF_RequestReturn=0
			BCF_ReturnedName$=""
		EndIf

		; ---------------------------------------------------------------
		; Si l'utilisateur a cliqué sur créer un directory
		; ---------------------------------------------------------------
		If BCF_TestButton(BCF_CreateDir) Then
			BCF_CreateTMPDir$=BCF_MsgInputBox$(BCF_FileRequestCreate$,"")

			If BCF_CreateTMPDir$<>"" Then 
				CreateDir BCF_Drive$ + BCF_Path$ + "\" +BCF_CreateTMPDir$

				BCF_KillItemChild(BCF_FileList)
				BCF_ReadFolder( BCF_FileList , BCF_Drive$ + BCF_Path$ + "\",Ext$,1)
			EndIf 
		EndIf
		
		; -----------------------------------------------------------------------------------------------------
		; Si l'utilisateur a clique sur ValIder on recupère le contenu de l'inputbox
		; -----------------------------------------------------------------------------------------------------
		If BCF_TestButton(BCF_ValIdate ) And  BCF_TestInputBox(BCF_InputFile)<>"" Then
			BCF_RequestReturn=0
			BCF_ReturnedName$=BCF_Drive$ + BCF_Path$ + "\" + BCF_TestInputBox(BCF_InputFile)
		EndIf
		
		; ----------------------------------------------------------
		; Si on clique sur une des icones du drive
		; ----------------------------------------------------------
		If BCF_TestIcon(BCF_IconDrive01) Then
			BCF_Drive$="C:"
			BCF_SelectedComboBoxValue( DriveList, BCF_Drive$ )
		EndIf

		If BCF_TestIcon(BCF_IconDrive02) Then
			BCF_Drive$="D:"
			BCF_SelectedComboBoxValue( DriveList, BCF_Drive$ )
		EndIf

		If BCF_TestIcon(BCF_IconDrive03) Then
			BCF_Drive$="E:"
			BCF_SelectedComboBoxValue( DriveList, BCF_Drive$ )
		EndIf

		If BCF_TestIcon(BCF_IconDrive04) Then
			BCF_Drive$="F:"
			BCF_SelectedComboBoxValue( DriveList, BCF_Drive$ )
		EndIf 
		
		; -----------------------------------------------------
		; On recupere le lecteur du ComboBox
		; -----------------------------------------------------
		BCF_Drive$=BCF_TestComboBox$( DriveList )

		If BCF_Drive$<>BCF_Old_Drive$ Then
			If ReadDir( BCF_Drive$)>0 Then
				BCF_KillItemChild(BCF_FileList)
				BCF_ReadFolder( BCF_FileList , BCF_Drive$,Ext$,1)
				BCF_Path$=""
				BCF_Old_Drive$=BCF_Drive$
				BCF_ChangeInputBoxLabel(BCF_InputFile,FileReqFile$)
				BCF_ChangeInputBoxLabel(path_label,BCF_Path$)
			Else
				BCF_MsgBox("Information",BCF_Drive$+BCF_FileRequestAlertMsg$,0)
				BCF_ActiveLastWindow()
				BCF_SelectedComboBoxValue( DriveList, BCF_Old_Drive$ )
				BCF_Drive$=BCF_Old_Drive$
			EndIf
		EndIf
		
		; --------------------------------------------------------
		; On recupere l'extension du ComboBox
		; -------------------------------------------------------
		NewExt$=BCF_TestComboBox$(comboExtList)
		
		If (NewExt$ <> Ext$)
		
			Ext$ = NewExt$
			If ReadDir( BCF_Drive$)>0 Then
				BCF_KillItemChild(BCF_FileList)
				BCF_ReadFolder( BCF_FileList , BCF_Drive$ + BCF_Path$,Ext$,1)
				BCF_ChangeInputBoxLabel(BCF_InputFile,FileReqFile$)
			Else
				BCF_MsgBox("Information",BCF_Drive$+BCF_FileRequestAlertMsg$,0)
				BCF_ActiveLastWindow()
			EndIf
			
		EndIf

		; ----------------------------------------------------------------
		; On recupere le fichier ou dossier selectionne
		; ----------------------------------------------------------------
		BCF_Folder$=BCF_TestListBox$(BCF_FileList)
		
		; -------------------------
		; Si different de rien
		; -------------------------
		If BCF_Folder$<>""  Then
			; -----------------------
			; C'est un dossier
			; -----------------------
			If BCF_TestListBoxType(BCF_FileList ) = 2 Then
				; ---------------------------------
				; Gestion du double click
				; ---------------------------------
				If BCF_MouseRelease_L Then
					If BCF_TimeOut( BCF_DblClickTimer ) = False And BCF_DblClick=1 Then
						BCf_DblClick=BCf_DblClick +1
					Else If BCF_DblClick=0 Or BCF_DblClick=1Then
						BCF_DblClickTimer = BCF_SetTimer(290 )
						BCF_FileReqTMPFolder$=BCF_Folder$
						BCF_DblClick=1
					Else
						BCF_DblClick=1
						BCF_FileReqTMPFolder$=""
					EndIf

					
					; -------------------------------------------------
					; Gestion de l'ouverture d'un dossier
					; -------------------------------------------------
					If BCf_DblClick=2  Then
						BCf_DblClick=0
						
						If BCF_Folder$<>BCF_Old_Folder$   Then
							If BCF_FileReqTMPFolder$=BCF_Folder$ Then

								
								; ------------------------------------------------------
								; Nous avons clique sur le retour racine
								; ------------------------------------------------------
								If BCF_TestIndexListBox( BCF_FileList ) = 0 And BCF_Path$<>"" Then
									BCF_Path$=""
									bparent=False
								Else
									; -----------------------------------------------------
									; Nous avons clique sur dossier parent
									; -----------------------------------------------------
									If BCF_TestIndexListBox( BCF_FileList ) = 1 And BCF_Path$<>"" Then
										bparent=True
									Else
										bparent=False
									EndIf
								EndIf

								; ------------------------------------
								; Creation du nouveau path
								; ------------------------------------
								BCF_Path$=  BCF_Path$ + "\" + BCF_Folder$
				
								If BCF_Path$="\." Then BCF_Path$=""
								
								; ---------------------------------
								; Ouverture du repertoire
								; ---------------------------------
								Repertoire=ReadDir( BCF_Drive$ + BCF_Path$  )
				
								; -----------------------------
								; Lecture du repertoire
								; -----------------------------
								If Repertoire>0 And BCF_Folder$<>"" Then
									BCF_KillItemChild(BCF_FileList)
									BCF_Old_Folder$=BCF_Folder$
									BCF_ReadFolder( BCF_FileList , BCF_Drive$ + BCF_Path$,Ext$,1)

									If bParent Then
										; ----------------------------------------------------------
										; On supprime le repertoire enfant du path
										; ----------------------------------------------------------
										BCF_Path$ =Left( BCF_Path$ , Instr (BCF_Path$ , "\..", 1)-1 )
										BCF_Path$ = Left( BCF_Path$ , BCF_PathFind( BCF_Path$ )-1 )
										BCF_Folder$=""
										BCF_Old_Folder$=""
									EndIf
								EndIf

								BCF_Old_Folder=""
								
							Else
								BCF_DblClick=0
								BCF_FileReqTMPFolder$=""
							EndIf
						EndIf
					EndIf
				EndIf				

				; Maj de l'infos du path
				BCF_ChangeInputBoxLabel( path_label, BCF_Path$)
			Else
				; ---------------------
				; C'est un fichier
				; ---------------------
				BCF_DblClick=0
				BCF_FileReqTMPFolder$=""
				
				If file$<>BCF_Folder$ Then
					BCF_ChangeInputBoxLabel(BCF_InputFile,BCF_Folder$)
					file$=BCF_Folder$
				EndIf
			EndIf
		EndIf
		
		CloseDir(Repertoire)

		UpdateWorld()		
		RenderWorld()

		; --------------------------------------------
		; Rafraichissement de l'interface
		; --------------------------------------------
		BCF_RenderBCF()
	
		Flip()
	Wend

	; -------------------------------
	; On efface les gadgets
	; -------------------------------
	BCF_KillWindow(FileRequester)
	BCF_Requester=False

	Return BCF_ReturnedName$
End Function

; -----------------------------------------------------------
; Permet d'afficher un selecteur de chemin
; -----------------------------------------------------------
Function BCF_PathRequester$( Title$="",ButtonValidate$="",ButtonCancel$="",FileReqPath$="")
	BCF_HalfWIdth=GraphicsWidth()/2
	BCF_HalfHeight=GraphicsHeight()/2
	
	BCF_RequestWIdth=400
	BCF_RequestHeight=400

	If Title$="" Then
		Title$=BCF_PathRequestTitle$
	EndIf

	If ButtonValidate$="" Then
		ButtonValidate$=BCF_PathRequestValidate$
	EndIf

	If ButtonCancel$="" Then
		ButtonCancel$=BCF_PathRequestCancel$
	EndIf 
	
	; ---------------------------------------------------------------
	; Definition de la position X et Y du requester
	; ---------------------------------------------------------------
	BCF_Px=BCF_HalfWIdth-(BCF_RequestWIdth/2)
	BCF_Py=BCF_HalfHeight-(BCF_RequestHeight/2)
	
	; ------------------------------
	; Creation de la fenetre
	; ------------------------------
	FileRequester = BCF_CreateWindow(BCF_Px,BCF_Py, BCF_RequestWIdth,BCF_RequestHeight,BCF_GuiStyle,2,Title$,True,False)

	; -------------------------------------------------------------
	; Creation de la combobox de choix de lecteur
	; -------------------------------------------------------------
	BCF_CreateLabelText(FileRequester,10,17,BCF_PathRequestDrive$,1,1,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))
	
	DriveList = BCF_CreateComboBox( FileRequester,110,12,60,145)
	
	BCF_CheckDrive=GetLogicalDrives()

	For i=0 To 25
		BCF_ShiftedData=BCF_CheckDrive Shr i
		BCF_BitValue = BCF_ShiftedData And 1
		
		If BCF_BitValue<>0
			BCF_AddComboBoxItem( DriveList,Str(Chr(65+i))+":" )
		EndIf
	Next

	; -------------------------------------------------------------------------------------------------------------------
	; Gestion du path d'ouverture, si le path est vide en prends la directory par defaut
	; -------------------------------------------------------------------------------------------------------------------
	If FileReqPath$="" Then
		FileReqPath$ = "C:"
	EndIf
	
	If Right$(FileReqPath$,1)="/" Or Right$(FileReqPath$,1)="\" Then 
		FileReqPath$ =Left$(FileReqPath$,Len(FileReqPath$)-1)
	EndIf 

	; ------------------------------
	; Extraction du lecteur
	; ------------------------------
	If BCF_bPath=False Then
		BCF_Drive$ = Upper$(Left$( FileReqPath$,2))
		BCF_Old_Drive$ = BCF_Drive$
		BCF_path$ = Mid$(  FileReqPath$,3,256)
		BCF_bPath=True
	EndIf

	BCF_SelectedComboBoxValue( DriveList, Upper$(BCF_Drive$) )

	; ------------------------------------------------
	; Creation de ma listbox des fichiers
	; ------------------------------------------------
	BCF_FileList = BCF_CreateListBox(FileRequester,10,45,BCF_RequestWIdth-25,BCF_RequestHeight-150)

	; -----------------------------------------------
	; L'inputbox de saisie ou de retour
	; -----------------------------------------------
	BCF_CreateLabelText(FileRequester,12,BCF_RequestHeight-95,BCF_PathRequestSelected$,1,1,BCF_GetRed(Bcf_Color03),BCF_GetGreen(Bcf_Color03), BCF_GetBlue(Bcf_Color03))
	path_label = BCF_CreateInputBox(FileRequester,12,BCF_RequestHeight-80,BCF_path$,255,False,1,45)

	; ------------------------------------------
	; Les boutons Annuler et ValIder
	; ------------------------------------------
	BCF_ValIdate = BCF_CreateButton(FileRequester,10,BCF_RequestHeight-50,StringWidth(ButtonValidate$)+20,20,ButtonValidate$,BCF_GuiStyle)

	BCF_CreateDir = BCF_CreateButton(FileRequester,BCF_RequestWIdth/2-StringWidth(BCF_FileRequestCreate$)/2-20,BCF_RequestHeight-50,StringWidth(BCF_FileRequestCreate$)+20,20,BCF_FileRequestCreate$,BCF_GuiStyle)

	BCF_Cancel = BCF_CreateButton(FileRequester,BCF_RequestWIdth-StringWidth(ButtonCancel$)-37,BCF_RequestHeight-50,StringWidth(ButtonCancel$)+20,20,ButtonCancel$,BCF_GuiStyle)
	
	; --------------------------------
	; Ouverture du repertoire
	; --------------------------------
	BCF_ReadFolder( BCF_FileList , BCF_Drive$ + BCF_Path$,Ext$,2)

	; -------------------------------------------------------------
	; On bloque la selection des autres fenêtres
	; -------------------------------------------------------------
	BCF_Requester = True
	BCF_RequestReturn=-1
	BCF_DblClick = 0
	
	While BCF_RequestReturn=-1
		; ---------------------------------------------
		; Si l'utilisateur a clique sur annule
		; ---------------------------------------------
		If BCF_TestButton(BCF_Cancel) Then
			BCF_RequestReturn=0
			BCF_ReturnedName$=""
		EndIf

		; ---------------------------------------------------------------
		; Si l'utilisateur a cliqué sur créer un directory
		; ---------------------------------------------------------------
		If BCF_TestButton(BCF_CreateDir) Then
			BCF_CreateTMPDir$=BCF_MsgInputBox$(BCF_FileRequestCreate$,"")

			If BCF_CreateTMPDir$<>"" Then 
				CreateDir BCF_Drive$ + BCF_Path$ + "\" +BCF_CreateTMPDir$

				BCF_KillItemChild(BCF_FileList)
				BCF_ReadFolder( BCF_FileList , BCF_Drive$ + BCF_Path$ + "\",Ext$,1)
			EndIf 
		EndIf
		
		; -----------------------------------------------------------------------------------------------------
		; Si l'utilisateur a clique sur Valider on recupère le contenu de l'inputbox
		; -----------------------------------------------------------------------------------------------------
		If BCF_TestButton(BCF_ValIdate ) And  BCF_TestInputBox(path_label )<>"" Then
			BCF_RequestReturn=0
			BCF_ReturnedName$=BCF_Drive$ + BCF_Path$ + "\" 
		EndIf

		; ------------------------------------------------------
		; On recupere le lecteur du ComboBox
		; ------------------------------------------------------
		BCF_Drive$=BCF_TestComboBox$( DriveList )

		If BCF_Drive$<>BCF_Old_Drive$ Then
			If ReadDir( BCF_Drive$)>0 Then
				BCF_KillItemChild(BCF_FileList)
				BCF_ReadFolder( BCF_FileList , BCF_Drive$,Ext$,2)
				BCF_Path$=""
				BCF_Old_Drive$=BCF_Drive$
			Else
				BCF_MsgBox("Information",BCF_Drive$+BCF_FileRequestAlertMsg$,0)
				BCF_ActiveLastWindow()
				BCF_SelectedComboBoxValue( DriveList, BCF_Old_Drive$ )
				BCF_Drive$=BCF_Old_Drive$
			EndIf
		EndIf
		
		; --------------------------------------------------------------
		; On recupere le fichier ou dossier selectionne
		; --------------------------------------------------------------
		BCF_Folder$=BCF_TestListBox$(BCF_FileList)
		
		; -------------------------
		; Si different de rien
		; -------------------------
		If BCF_Folder$<>""  Then
			; -----------------------
			; C'est un dossier
			; -----------------------
			If BCF_TestListBoxType(BCF_FileList ) = 2 Then
				; --------------------------------
				; Gestion du double click
				; --------------------------------
				If BCF_MouseRelease_L Then
					If BCF_TimeOut( BCF_DblClickTimer ) = False And BCF_DblClick=1 Then
						BCf_DblClick=BCf_DblClick +1
					Else If BCF_DblClick=0 Or BCF_DblClick=1Then
						BCF_DblClickTimer = BCF_SetTimer(290 )
						BCF_FileReqTMPFolder$=BCF_Folder$
						BCF_DblClick=1
					Else
						BCF_DblClick=1
						BCF_FileReqTMPFolder$=""
					EndIf

					; --------------------------------------------------
					; Gestion de l'ouverture d'un dossier
					; --------------------------------------------------
					If BCf_DblClick=2  Then
						BCf_DblClick=0
						
						If BCF_Folder$<>BCF_Old_Folder$   Then
							If BCF_FileReqTMPFolder$=BCF_Folder$ Then

								; ------------------------------------------------------
								; Nous avons clique sur le retour racine
								; ------------------------------------------------------
								If BCF_TestIndexListBox( BCF_FileList ) = 0 And BCF_Path$<>"" Then
									BCF_Path$=""
									bparent=False
								Else
									; -----------------------------------------------------
									; Nous avons clique sur dossier parent
									; -----------------------------------------------------
									If BCF_TestIndexListBox( BCF_FileList ) = 1 And BCF_Path$<>"" Then
										bparent=True
									Else
										bparent=False
									EndIf
								EndIf

								; ------------------------------------
								; Creation du nouveau path
								; ------------------------------------
								BCF_Path$=  BCF_Path$ + "\" + BCF_Folder$
				
								If BCF_Path$="\." Then BCF_Path$=""
								
								; --------------------------------
								; Ouverture du repertoire
								; --------------------------------
								Repertoire=ReadDir( BCF_Drive$ + BCF_Path$  )
				
								; -----------------------------
								; Lecture du repertoire
								; -----------------------------
								If Repertoire>0 And BCF_Folder$<>"" Then
									BCF_KillItemChild(BCF_FileList)
									BCF_Old_Folder$=BCF_Folder$
									BCF_ReadFolder( BCF_FileList , BCF_Drive$ + BCF_Path$,Ext$,2)

									If bParent Then
										; --------------------------------------------------------
										; On supprime le repertoire enfant du path
										; --------------------------------------------------------
										BCF_Path$ =Left( BCF_Path$ , Instr (BCF_Path$ , "\..", 1)-1 )
										BCF_Path$ = Left( BCF_Path$ , BCF_PathFind( BCF_Path$ )-1 )
										BCF_Folder$=""
										BCF_Old_Folder$=""
									EndIf
								EndIf

								BCF_Old_Folder=""
								
							Else
								BCF_DblClick=0
								BCF_FileReqTMPFolder$=""
							EndIf
						EndIf
					EndIf
				EndIf				

				; --------------------------------
				; Mise a jour du chemin
				; --------------------------------
				BCF_ChangeInputBoxLabel( Path_label, BCF_Path$)
			EndIf
		EndIf
		
		CloseDir(Repertoire)

		UpdateWorld()		
		RenderWorld()

		; -------------------------------------------
		; Rafraichissement de l'interface
		; -------------------------------------------
		BCF_RenderBCF()
	
		Flip()
	Wend

	; ------------------------------
	; On efface les gadgets
	; ------------------------------
	BCF_KillWindow(FileRequester)
	BCF_Requester=False

	Return BCF_ReturnedName$
End Function

; --------------------------------------------------------------------------------------------------------
; Permet la lecture d'un chemin pour le FileRequester et le path requester
; --------------------------------------------------------------------------------------------------------
Function BCF_ReadFolder( Id_list , Path$,Ext$,ReqType)
	; --------------------------------------------------------------
	; Modif pour accepter le .* comme extension
	; --------------------------------------------------------------
	If (Ext$ = ".*") Then Ext$ = ""

	; ---------------------------------------------------------
	; Premiere passe pour lire les répertoires
	; ---------------------------------------------------------
	directory=ReadDir(Path$ ) 

	Repeat  
		file$=NextFile$(directory) 
		If file$="" Then Exit 
		If FileType(Path$+"\"+file$) = 2 Then
			BCF_AddListBoxItem( Id_list, file$ ,700 , 2)
		End If
	Forever
	
	CloseDir(directory)

	; -----------------------------------------------------
	; Deuxieme passe pour lire les fichiers
	; -----------------------------------------------------
	directory=ReadDir(Path$ ) 

	If ReqType=1 Then 
		Repeat  
			file$=NextFile$(directory) 
			If file$="" Then Exit
				filename$=Path$+"\"+file$

				; -----------------------------------------------------------------------------------------------------------
				; Si c'est un fichier et si l'extension correspond a ce que l'utilisateur a rentré
				; ------------------------------------------------------------------------------------------------------------
				If FileType(filename$) <> 2 And Upper$(Right$(filename$,Len(Ext$)))=Upper$(Ext$) Then  
					; ---------------------------------------------------------
					; Recherche des extensions a 3 caractères
					; ---------------------------------------------------------
					Select Upper(Right(file$,4))
		
					; -----------
					; Images
					; -----------			
					Case ".JPG"
						BCF_AddListBoxItem( Id_list, file$ ,702 , 1)
					Case ".BMP"
						BCF_AddListBoxItem( Id_list, file$ ,702 , 1)
					Case ".PNG"
						BCF_AddListBoxItem( Id_list, file$ ,702 , 1)
					Case ".TGA"
						BCF_AddListBoxItem( Id_list, file$ ,702 , 1)
					Case ".PSD"
						BCF_AddListBoxItem( Id_list, file$ ,702 , 1)
					Case ".TGA"
						BCF_AddListBoxItem( Id_list, file$ ,702 , 1)
					Case ".TIF"
						BCF_AddListBoxItem( Id_list, file$ ,702 , 1)
					Case ".ICO"
						BCF_AddListBoxItem( Id_list, file$ ,702 , 1)
					; ----------------
					; Html et web
					; ----------------
					Case ".HTM"
						BCF_AddListBoxItem( Id_list, file$ ,703 , 1)
					Case ".PHP"
						BCF_AddListBoxItem( Id_list, file$ ,703 , 1)
					Case ".ASP"
						BCF_AddListBoxItem( Id_list, file$ ,703 , 1)
					Case ".URL"
						BCF_AddListBoxItem( Id_list, file$ ,703 , 1)
					; ---------------
					; Ocx et DLL
					; ---------------
					Case ".OCX"
						BCF_AddListBoxItem( Id_list, file$ ,704 , 1)
					Case ".DLL"
						BCF_AddListBoxItem( Id_list, file$ ,704 , 1)
					Case ".VBX"
						BCF_AddListBoxItem( Id_list, file$ ,704 , 1)
					; ---------------
					; Texte et Ini
					; ---------------
					Case ".TXT"
						BCF_AddListBoxItem( Id_list, file$ ,705 , 1)
					Case ".INI"
						BCF_AddListBoxItem( Id_list, file$ ,705 , 1)
					Case ".DOC"
						BCF_AddListBoxItem( Id_list, file$ ,705 , 1)
					Case ".BAT"
						BCF_AddListBoxItem( Id_list, file$ ,705 , 1)
					Case ".NFO"
						BCF_AddListBoxItem( Id_list, file$ ,705 , 1)
					; ---------
					; VIdeos
					; ---------
					Case ".AVI"
						BCF_AddListBoxItem( Id_list, file$ ,706 , 1)
					Case ".MPG"
						BCF_AddListBoxItem( Id_list, file$ ,706 , 1)
					Case ".MOV"
						BCF_AddListBoxItem( Id_list, file$ ,706 , 1)
					Case ".RAM"
						BCF_AddListBoxItem( Id_list, file$ ,706 , 1)
					; ---------
					; Audio
					; ---------
					Case ".WAV"
						BCF_AddListBoxItem( Id_list, file$ ,707 , 1)
					Case ".MP3"
						BCF_AddListBoxItem( Id_list, file$ ,707 , 1)
					Case ".MId"
						BCF_AddListBoxItem( Id_list, file$ ,707 , 1)
					; ---------------
					; Executable
					; ---------------
					Case ".EXE"
						BCF_AddListBoxItem( Id_list, file$ ,709 , 1)
					Case ".COM"
						BCF_AddListBoxItem( Id_list, file$ ,709, 1)
					; ----------------
					; Compressé
					; ----------------
					Case ".ZIP"
						BCF_AddListBoxItem( Id_list, file$ ,708 , 1)
					Case ".RAR"
						BCF_AddListBoxItem( Id_list, file$ ,708, 1)
					; -----------
					; Inconnu
					; -----------
					Default
						BCF_AddListBoxItem( Id_list, file$ ,701 , 1)
					End Select
				End If
		Forever
	EndIf 
	
	CloseDir(directory)
End Function

Function BCF_PathFind( Path$ )
	For i=Len(Path$) To 0 Step -1
		char$= Mid$ (Path$, i, 1)
		If char="\" Then Return i
	Next
End Function

Function BCF_GetDriveType%(BCF_DriveLetter$)
        Return GetDriveType(BCF_DriveLetter$)
End Function

; --------------------------------------------------
; Permet de selectionner les couleurs
; --------------------------------------------------
Function BCF_Color(ColNum)
	Col.BCF_TColor =Object.BCF_TColor(ColNum)
	Color Col\R,Col\G,Col\B
End Function 

; ----------------------------------------------------------------------
; Permet de recuperer les valeurs RVB des couleurs
; ----------------------------------------------------------------------
Function BCF_GetRed(ColNum)
	Col.BCF_TColor =Object.BCF_TColor(ColNum)
	Return Col\R
End Function

Function BCF_GetGreen(ColNum)
	Col.BCF_TColor =Object.BCF_TColor(ColNum)
	Return Col\G
End Function

Function BCF_GetBlue(ColNum)
	Col.BCF_TColor =Object.BCF_TColor(ColNum)
	Return Col\B
End Function

; -------------------------------------------------------------
; Permet définir les valeurs RVB d'une couleur
; -------------------------------------------------------------
Function BCF_SetColor(ColNum,R,G,B)
	Col.BCF_TColor =Object.BCF_TColor(ColNum)
	Col\R=R
	Col\G=G
	Col\B=B
End Function

; ----------------------------------------
; Permet de créer les couleurs
; ----------------------------------------
Function BCF_CreateColor( r,g,b )
	Col.BCF_TColor = New BCF_TColor
	Col\R = R
	Col\G = G
	Col\B = B

	Return Handle(Col)
End Function

; ----------------------------------------------------
; Permet de détruire toutes les couleurs
; ----------------------------------------------------
Function BCF_DeleteAllColor()
	For Col.BCF_TColor = Each BCF_TColor
		Delete Col
	Next
End Function

; -------------------------------------------
; Permet de détruire une couleur
; -------------------------------------------
Function BCF_DeleteOneColor(ColNum)
	Col.BCF_TColor =Object.BCF_TColor(ColNum)
	Delete Col
End Function

; --------------------------------------------------------
; Permet de scaler rapidement une image
; --------------------------------------------------------
Function BCF_ScaleImageFast(Image,Newwidth,Newheight,Frame=0)
	Local tbuffer = GraphicsBuffer ()
	
    Local oldwidth = ImageWidth(image)
    Local oldheight = ImageHeight(image)

    newwidth=newwidth-1
    newheight=newheight-1

	Local newimage=CreateImage(newwidth+1,oldheight)
    Local dest = CreateImage(newwidth+1,newheight+1)

	SetBuffer ImageBuffer(newimage)

	For x = 0 To newwidth
        Local LineRef = Floor((oldwidth*x)/newwidth)
        DrawBlockRect image,x,0,LineRef,0,1,oldheight,frame
    Next
	
    SetBuffer ImageBuffer(dest)

	For y = 0 To newheight
        LineRef = Floor((oldheight*y)/newheight)
        DrawBlockRect newimage,0,y,0,LineRef,newwidth,1
    Next
	
    FreeImage newimage

	SetBuffer tbuffer
	
    Return Dest
End Function
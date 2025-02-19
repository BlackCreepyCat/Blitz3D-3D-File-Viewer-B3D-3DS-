; **********************************************************************
; * Include     : BCF Librairie (GUI pour Blitz3D)				*
; * 											*
; * Version    : V2.0 Par Philippe Agnisola	et Nicolas Poursin	*
; **********************************************************************
Include "Inc_BCF3.bb"

Include "../../Includes\Inc_Camera.bb"
Include "../../Includes\Inc_Keydef.bb"
Include"../../Includes\Inc_Light.bb"
Include "../../Includes\Inc_AnimMeshControl.bb"
Include "../../Includes\Inc_3DGrid.bb"
Include "../../Includes/Inc_TimeMachine.bb"

Graphics3D 1024,768,32,2
SetBuffer BackBuffer()

Global Version$="BCF Viewer Version 1.2"

; --------------------------------------------------
; Globales de la fenetre de Hierarchie
; --------------------------------------------------
Global HelpWin
Global ChildWin
Global ChildList
Global OptionsWin

; ---------------------------------
; Innitialisation de la BCF
; ---------------------------------
BCF_InitBCF(2,1)

; -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
; Proc_CreateCamera(Px#,Py#,Pz#,Radius#,Near#,Far#,Zoom#,FogOn,FogNear#,FogFar#,FogRed#,FogGreen#,FogBlue#)
; -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Camera=Proc_CreateCamera(0,10,-20,5,0.01,60000)

Light1=Proc_CreateOmniLight(0,0,0,False,1000,255,255,255,1)
Light2=Proc_CreateOmniLight(0,0,0,False,1000,255,255,255,1)
MoveMouse GraphicsWidth()/2, GraphicsHeight()/2

; -----------------------------------
; Innitialisation de la souris
; -----------------------------------
BCF_Init3DMouse(6)

; ------------------------------------
; On définition de l'interface
; ------------------------------------
MaFenetre=BCF_CreateWindow(0,0,196,747,BCF_GuiStyle,52,Version$,True,False,True)

Frame01=BCF_CreateFrame(Mafenetre,2,8,188,160,"Modification d'objet")
Frame02=BCF_CreateFrame(Mafenetre,2,198,188,40,"Déplacement caméra")
Frame03=BCF_CreateFrame(Mafenetre,2,268,188,190,"Lumières")

TxTmp=BCF_GetWindowWIdth(MaFenetre)-38
RotateX=BCF_CreateSlIder(MaFenetre,7,20,TxTmp,20,-1.0,1.0,0.0,False,"Rotation X",BCF_GuiStyle,250,100,50)
RotateY=BCF_CreateSlIder(MaFenetre,7,50,TxTmp,20,-1.0,1.0,0.0,False,"Rotation Y",BCF_GuiStyle,250,100,50)
RotateZ=BCF_CreateSlIder(MaFenetre,7,80,TxTmp,20,-1.0,1.0,0.0,False,"Rotation Z",BCF_GuiStyle,250,100,50)
Resize=BCF_CreateSlIder(MaFenetre,7,110,TxTmp,20,1,20.0,1.0,False,"Taille",BCF_GuiStyle,250,100,50)
AlphaObj=BCF_CreateSlIder(MaFenetre,7,140,TxTmp,20,0.0,1.0,1.0,False,"Transparence",BCF_GuiStyle,250,100,50)

Speed=BCF_CreateSlIder(MaFenetre,7,210,TxTmp,20,0.1,5,0.1,False ,"Vitesse",BCF_GuiStyle,250,100,50)

Location=BCF_CreateSlIder(MaFenetre,7,280,TxTmp,20,1,300,90,True ,"Ecartement",BCF_GuiStyle,250,100,50)
Bright=BCF_CreateSlIder(MaFenetre,7,310,TxTmp,20,1,1000,150,True ,"Puissance",BCF_GuiStyle,250,100,50)

Red=BCF_CreateSlIder(MaFenetre,7,340,TxTmp,20,0,255,200,True ,"Rouge",BCF_GuiStyle,255,50,10)
Green=BCF_CreateSlIder(MaFenetre,7,370,TxTmp,20,0,255,200,True ,"Vert",BCF_GuiStyle,50,255,50)
Blue=BCF_CreateSlIder(MaFenetre,7,400,TxTmp,20,0,255,200,True ,"Bleu",BCF_GuiStyle,50,100,200)

Ambient=BCF_CreateSlIder(MaFenetre,7,430,TxTmp,20,0,255,40,True ,"Ambiance",BCF_GuiStyle,250,100,50)

StopRotationX=BCF_CreateButton(MaFenetre,167,20,18,18,"R",BCF_GuiStyle)
StopRotationY=BCF_CreateButton(MaFenetre,167,50,18,18,"R",BCF_GuiStyle)
StopRotationZ=BCF_CreateButton(MaFenetre,167,80,18,18,"R",BCF_GuiStyle)

ResetSize=BCF_CreateButton(MaFenetre,167,110,18,18,"R",BCF_GuiStyle)
ResetAlpha=BCF_CreateButton(MaFenetre,167,140,18,18,"R",BCF_GuiStyle)

ResetVitesse=BCF_CreateButton(MaFenetre,167,210,18,18,"R",BCF_GuiStyle)
ResetLocation=BCF_CreateButton(MaFenetre,167,280,18,18,"R",BCF_GuiStyle)
ResetBright=BCF_CreateButton(MaFenetre,167,310,18,18,"R",BCF_GuiStyle)

ResetRed=BCF_CreateButton(MaFenetre,167,340,18,18,"R",BCF_GuiStyle)
ResetGreen=BCF_CreateButton(MaFenetre,167,370,18,18,"R",BCF_GuiStyle)
ResetBlue=BCF_CreateButton(MaFenetre,167,400,18,18,"R",BCF_GuiStyle)

ResetAmbient=BCF_CreateButton(MaFenetre,167,430,18,18,"R",BCF_GuiStyle)

GravityMode=BCF_CreateCheckbox(MaFenetre,5,480,0,"Gérer la gravité caméra ?")
CollideMode=BCF_CreateCheckbox(MaFenetre,5,510,0,"Gérer les collisions objets ?")
InfoMode=BCF_CreateCheckbox(MaFenetre,5,540,1,"Afficher les informations ?")
DrawGrid=BCF_CreateCheckbox(MaFenetre,5,570,1,"Affichage de la grille en 3D ?")
WireMode=BCF_CreateCheckbox(MaFenetre,5,600,0,"Affichage en 'Wireframe' ?")

ShowList=BCF_CreateButton(MaFenetre,5,630,85,20,"Hiérarchie",BCF_GuiStyle)
ShowOptions=BCF_CreateButton(MaFenetre,95,630,90,20,"Options",BCF_GuiStyle)
ResetCamera=BCF_CreateButton(MaFenetre,5,660,BCF_GetWindowWIdth(MaFenetre)-15,20,"Réinitialiser camera",BCF_GuiStyle)

Ouvrir=BCF_CreateButton(MaFenetre,5,695,50,20,"Ouvrir",BCF_GuiStyle)
Aide=BCF_CreateButton(MaFenetre,70,695,50,20,"Aide",BCF_GuiStyle)
Quitter=BCF_CreateButton(MaFenetre,BCF_GetWindowWIdth(MaFenetre)-60,695,50,20,"Quitter",BCF_GuiStyle)


InfoWidth=1024
InfoPx=GraphicsWidth()/2-InfoWidth/2
InfoPy=GraphicsHeight()-21
Information=BCF_CreateInfoText(InfoPx,InfoPy,InfoWidth,20,1,"")

; ---------------------------
; Creation de la grille
; ---------------------------
Grid=Create_3DGrid(512,10,20,50,100,250)

; -------------------------
; Boucle de gestion
; -------------------------
Velocity#=1.1
LoadedMesh=0
Tp_OldTime=MilliSecs()

While Not KeyDown( 1 )
	
	; -----------------------------
	; On switche la vue 3D
	; -----------------------------
	Vitesse#=BCF_TestSlIder(Speed)

	If MouseHit (2) Then
		MoveMouse GraphicsWidth()/2, GraphicsHeight()/2
	EndIf
	
	If MouseDown(2) Then
		Proc_MoveFreelookCam(Camera,Velocity#,Vitesse#,Gravity#)
	EndIf
	
	; ------------------------------------------------------
	; Permet de gerer la grille en double face
	; ------------------------------------------------------
	If EntityY(Camera)<0 Then 
		RotateEntity Grid,0,0,180
	EndIf
	
	If EntityY(Camera)>0 Then 
		RotateEntity Grid,0,0,0
	EndIf

	; ----------------------------------
	; On teste le bouton Outils
	; ----------------------------------
	If BCF_TestButton(ShowOptions)  Then
		Show_Options()
	EndIf
	
	; -----------------------------------
	; On teste le bouton ouvrir
	; -----------------------------------
	If BCF_TestButton(Ouvrir)  Then
		; -------------------------------
		; Affichage du selecteur
		; -------------------------------
		Selecteur$=BCF_FileRequester("Ouvrir un fichier 2D ou 3D","Ouvrir", "Annuler",".*|.b3d|.3ds|.x") 

		If Selecteur$<>"" Then
			; ------------------------------------
			; Chargement d'une image
			; ------------------------------------
			If  Upper(Right(Selecteur$,4))=".JPG" Or Upper(Right(Selecteur$,4))=".BMP" Or Upper(Right(Selecteur$,4))=".PNG"  Then
				TmpBitmap=LoadImage(Selecteur$)
				TmpTx=ImageWidth(TmpBitmap)
				TmpTy=ImageHeight(TmpBitmap)
				FreeImage TmpBitmap

				If TmpTx>GraphicsWidth() Or TmpTy>GraphicsHeight() Then
					TmpTx=TmpTx/2
					TmpTy=TmpTy/2
				EndIf
			
				Bitmap=BCF_CreateWindow(150,150,TmpTx+11,TmpTy+33,BCF_GuiStyle,1,Selecteur$,True,True)
				Image=BCF_CreateImage(Bitmap,3,3,TmpTx,TmpTy,Selecteur$)
				BCF_ActiveLastWindow()

				Goto suite
			EndIf

			; --------------------------------------
			; Chargement d'un objet 3D
			; --------------------------------------
			If  Upper(Right(Selecteur$,4))=".3DS" Or Upper(Right(Selecteur$,2))=".X" Or Upper(Right(Selecteur$,4))=".B3D" Then
				FreeEntity Objet
				Objet=LoadAnimMesh(Selecteur$)
				PositionEntity Objet,0,0,0
				PointEntity Camera ,Objet
				MoveMouse GraphicsWidth()/2, GraphicsHeight()/2
				LoadedMesh=1
				
				; -------------------------------
				; Gestion des collisions
				; -------------------------------
				Proc_AnimMeshType(Objet, 2)
				Collisions 1,2,2,2
			Else
				BCF_MsgBox("Information","Aucun fichier média séléctionné ! ou ce n'est pas un fichier lisible par le lecteur ...." ,0)
			EndIf
		EndIf
	EndIf 

	.Suite
	; -----------------------------
	; On teste les boutons
	; -----------------------------
	If BCF_TestButton(StopRotationX)  Then
		BCF_ChangeSliderValue(RotateX,0.0)
	EndIf

	If BCF_TestButton(StopRotationY)  Then
		BCF_ChangeSliderValue(RotateY,0.0)
	EndIf

	If BCF_TestButton(StopRotationZ)  Then
		BCF_ChangeSliderValue(RotateZ,0.0)
	EndIf

	If BCF_TestButton(ResetSize)  Then
		BCF_ChangeSliderValue(ReSize,1.0)
	EndIf

	If BCF_TestButton(ResetAlpha)  Then
		BCF_ChangeSliderValue(AlphaObj,1.0)
	EndIf

	If BCF_TestButton(ResetVitesse)  Then
		BCF_ChangeSliderValue(Speed,10)
	EndIf

	If BCF_TestButton(ResetLocation)  Then
		BCF_ChangeSliderValue(Location,90)
	EndIf

	If BCF_TestButton(ResetBright)  Then
		BCF_ChangeSliderValue(Bright,150)
	EndIf

	If BCF_TestButton(ResetRed)  Then
		BCF_ChangeSliderValue(Red,200)
	EndIf

	If BCF_TestButton(ResetGreen)  Then
		BCF_ChangeSliderValue(Green,200)
	EndIf

	If BCF_TestButton(ResetBlue)  Then
		BCF_ChangeSliderValue(Blue,200)
	EndIf

	If BCF_TestButton(ResetAmbient)  Then
		BCF_ChangeSliderValue(Ambient,40)
	EndIf

	; ---------------------------------------------
	; Réduction de toutes les fenetres
	; ---------------------------------------------
	If KeyHit(Key_Space) Then
			GUI_Active=BCF_Switch(GUI_Active)

			If GUI_Active=1 Then 
				BCF_MinimizeAllWindow()
			Else
				BCF_MaximizeAllWindow()
			EndIf 
	EndIf
	
	; --------------
	; Collisions
	; --------------
	If BCF_TestCheckbox(GravityMode)=1   Then
		Gravity#=-2
	Else
		Gravity#=0
	EndIf
	
	; --------------
	; Collisions
	; --------------
	If BCF_TestCheckbox(CollideMode)=1   Then
		UpdateWorld
	EndIf
	
	; ----------------
	; Mode Grille
	; ----------------
	If BCF_TestCheckbox(DrawGrid)=1   Then
		ShowEntity Grid
	Else
		HideEntity Grid
	EndIf
	
	; ------------------------
	; Mode WireFrame
	; ------------------------
	If BCF_TestCheckbox(WireMode)=1   Then
		WireFrame True
	Else
		WireFrame False 
	EndIf

	; ------------------------
	; Mode Information
	; ------------------------
	If BCF_TestCheckbox(InfoMode)=1   Then
		BCF_ChangeInfoTextPosition(Information,InfoPx,InfoPy)
	Else
		BCF_ChangeInfoTextPosition(Information,InfoPx,InfoPy+50)
	EndIf

	MemTotal=TotalVidMem()/1024
	MemAvail=AvailVidMem()/1024
	BCF_ChangeInfoTextLabel(Information,"Poly : "+TrisRendered()+" / Fps : "+Get_FPS()+" Img"+" / Memoire vidéo totale : "+Str(MemTotal)+" / Restante : "+Str(MemAvail)+" / Utilisé : "+Str(MemTotal-MemAvail))

	; ---------------------------------
	; Fenetre de la hierarchie
	; ---------------------------------
	If BCF_TestButton(ShowList) And LoadedMesh=1 Then
		Show_ChildList(Objet)
	EndIf

	; ----------------------------------------
	; Reinitialisation de la Camera
	; ----------------------------------------
	If BCF_TestButton(ResetCamera) Then
		Proc_MoveCamera(Camera,0,10,-20)
		Proc_RotateCamera(Camera,0,0,0)
	EndIf

	; -----------------------
	; Fenetre de l'aide
	; -----------------------
	If BCF_TestButton(Aide)  Then
		Show_Help()
	EndIf

	; --------------------------------------------
	; Gestion de la liste de hierarchie
	; --------------------------------------------
	If BCF_Window( ChildWin )=True Then
		Proc_AnimMeshChildAlpha(Objet,OldChild$,1)
		Proc_AnimMeshChildColor(Objet,OldChild$,255,255,255)
	
		Child$=BCF_TestListBox$(ChildList)
		Proc_AnimMeshChildAlpha(Objet,Child$,0.5)
		Proc_AnimMeshChildColor(Objet,Child$,255,0,0)

		OldChild$=Child$
	EndIf

	; --------------------------------
	; Position des lumières
	; --------------------------------
	LumScale#=BCF_TestSlIder(Location)
	PositionEntity Light1,LumScale#,-LumScale#,-LumScale#
	PositionEntity Light2,-LumScale#,LumScale#,LumScale#

	; -----------------------------
	; Range des lumières
	; -----------------------------
	LumRange=BCF_TestSlIder(Bright)
	Proc_ChangeLightRange(Light1,LumRange)
	Proc_ChangeLightRange(Light2,LumRange)

	; -------------------------------
	; Couleur des lumieres
	; -------------------------------
	LumRed=BCF_TestSlIder(Red)
	LumGreen=BCF_TestSlIder(Green)
	LumBlue=BCF_TestSlIder(Blue)
	Proc_ChangeLightColor(Light1,LumRed,LumGreen,LumBlue)
	Proc_ChangeLightColor(Light2,LumRed,LumGreen,LumBlue)

	LumAmbient=BCF_TestSlIder(Ambient)
	AmbientLight LumAmbient,LumAmbient,LumAmbient

	; --------------------------------
	; Rotation et dimension
	; --------------------------------
	RotX#=BCF_TestSlIder(RotateX)
	RotY#=BCF_TestSlIder(RotateY)
	RotZ#=BCF_TestSlIder(RotateZ)
	Size#=BCF_TestSlIder(Resize)
	Alpha#=BCF_TestSlIder(AlphaObj)
	
	; ---------------------------
	; Si l'objet est chargé
	; ---------------------------
	If LoadedMesh=1 Then
		TurnEntity Objet, RotX#,RotY#,RotZ#
		ScaleEntity Objet,Size#,Size#,Size#
		Proc_AnimMeshAlpha(Objet,Alpha#)
	EndIf

	; ----------------------------------
	; On quitte si nécessaire
	; ----------------------------------
	If BCF_TestButton(Quitter) Then
		BCF_KillBCF()
		End
	EndIf

	RenderWorld
		
	; -------------------------
	; Gestion de la BCF
	; -------------------------
	BCF_RenderBCF()
	Flip
Wend

; ---------------------------------
; On quitte le programme
; ---------------------------------
BCF_KillBCF()
End

; -------------------------------------------------
; Permet d'afficher une fenetre d'aide
; -------------------------------------------------
Function Show_Help()
	HalfWIdth=GraphicsWidth()/2
	HalfHeight=GraphicsHeight()/2

	; ---------------------------------------
	; Mise en forme de la fenetre
	; --------------------------------------
	RequestWIdth=600
	RequestHeight=355	

	; ---------------------------------------------------------------
	; Definition de la position X et Y du requester
	; ---------------------------------------------------------------
	Px=HalfWIdth-(RequestWIdth/2)
	Py=HalfHeight-(RequestHeight/2)

	If BCF_Window( HelpWin)=False Then 
		HelpWin=BCF_CreateWindow(Px,Py,RequestWIdth,RequestHeight,BCF_GuiStyle,5,"Aide",True,True)
		Liste=BCF_CreateListBox(HelpWin,3,5,RequestWIdth-10,RequestHeight-35)
		BCF_AddListBoxItem( Liste, Version$)
		BCF_AddListBoxItem( Liste, "-----------------------------------")
		BCF_AddListBoxItem( Liste, "")
		BCF_AddListBoxItem( Liste, "Bouton droit de la souris : Pour activer ou non le mode 'Déplacement libre'")
		BCF_AddListBoxItem( Liste, "")
		BCF_AddListBoxItem( Liste, "Bouton 'Ouvrir' : Permet de charger un fichier image ou un fichier 3D.")
		BCF_AddListBoxItem( Liste, "")
		BCF_AddListBoxItem( Liste, "Bouton 'Quitter' : Permet de quitter le visualiseur.")
		BCF_AddListBoxItem( Liste, "")
		BCF_AddListBoxItem( Liste, "Bouton 'Affichage en WireFrame ?' : Permet de sélectionner le mode d'affichage en 'Fil de fer'.")
		BCF_AddListBoxItem( Liste, "")
		BCF_AddListBoxItem( Liste, "Touche 'Espace' : Permet de réduire ou non l'interface'.")
		BCF_AddListBoxItem( Liste, "")
	EndIf 
End Function

; ---------------------------------------------------------------------------------------------------------------------
; Permet d'afficher une fenetre comprenant la liste des objets contenu dans une scene
; ---------------------------------------------------------------------------------------------------------------------
Function Show_ChildList(Entity)
	HalfWIdth=GraphicsWidth()/2
	HalfHeight=GraphicsHeight()/2

	; ---------------------------------------
	; Mise en forme de la fenetre
	; --------------------------------------
	RequestWIdth=195
	RequestHeight=747

	; -----------------------------------------------------------
	; Definition de la position X et Y du requester
	; -----------------------------------------------------------
	Px=GraphicsWidth()-RequestWIdth
	Py=0

	If BCF_Window( ChildWin)=False Then 
		ChildWin=BCF_CreateWindow(Px,Py,RequestWIdth,RequestHeight,BCF_GuiStyle,5,"Hiérarchie",True,True)
		ChildList=BCF_CreateListBox(ChildWin,3,5,RequestWIdth-10,RequestHeight-35)

		; ------------------------------------------------
		; Affichage de la hierarchie de l'objet
		; ------------------------------------------------
		If CountChildren(Entity) > 0 
			For Childcount = 1 To CountChildren(Entity) 
				Child = GetChild(Entity,Childcount)
				BCF_AddListBoxItem(ChildList,EntityName$(Child))
			Next 
		EndIf
	EndIf 
End Function

Function Show_Options()
	HalfWIdth=GraphicsWidth()/2
	HalfHeight=GraphicsHeight()/2

	; ---------------------------------------
	; Mise en forme de la fenetre
	; --------------------------------------
	RequestWIdth=600
	RequestHeight=355	

	; -----------------------------------------------------------
	; Definition de la position X et Y du requester
	; -----------------------------------------------------------
	Px=HalfWIdth-(RequestWIdth/2)
	Py=HalfHeight-(RequestHeight/2)
	
	If BCF_Window( OptionsWin)=False Then 
		OptionsWin=BCF_CreateWindow(Px,Py,RequestWIdth,RequestHeight,BCF_GuiStyle,2,"Options",True,True)
	EndIf 
End Function
package ui

import appModel.AppModelControlGastos
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.tables.Table
import model.Gasto
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.bindings.DateTransformer

class ControlDeGastosWindow extends Window<AppModelControlGastos>{
	
	new(WindowOwner owner, AppModelControlGastos model) {
		super(owner, model)
	}
	
	override createContents(Panel mainPanel) {
		new Panel(mainPanel) => [
			this.title = "Control de gastos"
			layout = new HorizontalLayout
			
			val panelIzquierdo = new Panel(it) => [
			layout = new VerticalLayout
			panelPresentacion(it)
			panelBusqueda(it)
			panelTablaDeGastos(it)
			]
			
			val panelDerecho = new Panel(it) => [
			layout = new VerticalLayout
			panelNuevoGasto(it)
			]
		]
	}
	
	def panelPresentacion(Panel miPanel) {
		panelUsuario(miPanel)
		panelTotalGastado(miPanel)
	}
	
	def panelUsuario(Panel miPanel) {
		new Panel(miPanel) => [
			layout = new HorizontalLayout
			titulo(it, "Hola! ")
			new Label(it) => [value <=> "usuario.nombre"
				fontSize = 14
			]
			titulo(it, " estos son tus gastos")
		]
	}
	
	def panelTotalGastado(Panel miPanel) {
		new Panel(miPanel) => [
			layout = new HorizontalLayout
			subtitulo(it, "Llevas gastado: ")
			labelBinding(it, "totalDeGastos")
			subtitulo(it, " en total")
		]
	}
	
	def panelBusqueda(Panel miPanel) {
		panelDeBusquedaDeDescripcion(miPanel)
		panelFiltrar(miPanel)
	}
	
	def panelFiltrar(Panel miPanel) {
		new Panel(miPanel) => [
			layout = new HorizontalLayout 
			new Button(it) => [
			caption = "Filtrar"
			onClick([| modelObject.buscarDescripcion()])
			]
			subtitulo(it, "Gastos de la descripcion Buscada = ")
			labelBinding(it, "totalDeDescripcionBuscada")
		]
	}
	
	def panelDeBusquedaDeDescripcion(Panel miPanel) {
		new Panel(miPanel) => [
			layout = new HorizontalLayout 
			subtitulo(it, "Filtrar por Descripcion: ")
			busqueda(it, "busquedaDescripcion")
		]
	}
	
	
	
	def panelNuevoGasto(Panel miPanel) {
		new Panel(miPanel) => [
			titulo(it, "Nuevo Gasto")
			subtitulo(it, "Descripcion")
			busqueda(it, "nuevaDescripcion")
			subtitulo(it, "Monto")
			busqueda(it, "nuevoMonto")
		]
		new Panel(miPanel) => [ 
		new Button(it) => [
			caption = "Agregar"
			onClick([| modelObject.agregarNuevaCalificacion])
		]
		]	
	}
	
	
	
	def panelTablaDeGastos(Panel miPanel) {
			val table = new Table<Gasto>(miPanel, typeof(Gasto)) => [
				items <=> "buscarDescripcion"
				value <=> "gastoSeleccionado"
				numberVisibleRows = 10
			]
		this.descripcionDeLaTabla(table)
	}
	
	def descripcionDeLaTabla(Table<Gasto> table){
		new Column<Gasto>(table) => [
			title = "Mes"
			fixedSize = 150
			bindContentsToProperty("fecha")
		]
		
		new Column<Gasto>(table) => [
			title = "Descripcion"
			fixedSize = 150
			bindContentsToProperty("descripcion")
		]
		
		new Column<Gasto>(table) => [
			title = "Monto"
			fixedSize = 150
			bindContentsToProperty("monto")
		]
		
	}
	
	
	//************Auxiliares***************************
	
	
	def titulo(Panel miPanel, String unTitulo) {
		new Panel(miPanel) => [
		new Label(it) => [text = unTitulo
							   fontSize = 14 ]
							  ]
	}
	
	def subtitulo(Panel miPanel, String unSubtitulo) {
		new Panel(miPanel) => [
			new Label(it) => [text = unSubtitulo]
		]
	}
	
	def busqueda(Panel busquedaPanel, String unBinding) {
		new Panel(busquedaPanel) => [
			layout = new HorizontalLayout
		new TextBox(it) => [
			value <=> unBinding
			width = 200
		]
		]
	}
	
	def labelBinding(Panel miPanel, String unBinding) {
		new Label(miPanel) => [value <=> unBinding
			]
	}
}
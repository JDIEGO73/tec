public class BilleteraV2 {

	class Denominacion
	{
		private int denominacion, noBilletes;

		public Denominacion(int denominacion, int noBilletes)
		{
			this.denominacion=denominacion;
			this.noBilletes=noBilletes;
		}
		public int getDenominacion() {
			return denominacion;
		}
		public void setDenominacion(int denominacion) {
			this.denominacion = denominacion;
		}
		public int getNoBilletes() {
			return noBilletes;
		}
		public void setNoBilletes(int noBilletes) {
			this.noBilletes = noBilletes;
		}
		
	}

	private String marca,color,material, msg;
	private Denominacion [] denominacion;
	private int maxBilletes, maxTarjetas, noBilletes, noTarjetas,dineroTotal;
	private boolean cerrada;
	
	public BilleteraV2() {
		this("PATITO","AZUL","SINTETICO");
	}
	public BilleteraV2(String marca, String color, String material)
	{
		this.marca=marca;
		this.color=color;
		this.material=material;
		noBilletes=0;
		noTarjetas=0;
		dineroTotal=0;
		cerrada=true;
		if( material.equalsIgnoreCase("Piel") ) {
			maxBilletes=50;
			maxTarjetas=5;
		}
		else {
			maxBilletes=20;
			maxTarjetas=3;
		}
		
		int [] den= {1000,500,200,100,50,20};
		denominacion=new Denominacion[den.length];
		for(int i=0 ; i<den.length ; i++)
			denominacion[i]=new Denominacion(den[i],0);
		
	}

	//_______________Abrir y cerrar billetera___________________________________________________________________________
	public boolean Abrir() {
		if( !cerrada)
			return false;
		cerrada=false;
		return true;
	}
	public boolean Cerrar() {
		cerrada=true;
		return true;
	}

	//_________________________________meter billetes__________________________________________________________________
	public boolean MeterBilletes(int noBilletes, int denominacion) {
		if( !MeterBilletes(noBilletes) )
		{
			return false;
		}	
		
		int pos=-1;
		for(int i=0 ; i<this.denominacion.length;i++)
		{
			if(this.denominacion[i].getDenominacion()==denominacion)
			{
				pos=i;
				break;
			}
		}

		if(pos==-1)
		{
			this.noBilletes-=noBilletes;
			msg="Denominacion incorrecta ";
			return false;
		}
		this.denominacion[pos].setNoBilletes(this.denominacion[pos].getNoBilletes()+noBilletes);
		
		return true;
	}

	//_________________sacar billetes__________________________________________________________________________________
	public boolean SacarBilletes(int noBilletes,int denominacion) {
		if( cerrada) {
			msg="La billetera se encuentra cerrada";
			return false;
		}
		if( noBilletes > this.noBilletes ) {
			msg="No hay suficientes billetes en la billetera";
			return false;
		}
		this.noBilletes-=noBilletes;
		msg="Extraction de billetes exitosa";
		return true;
		return true;
	}

	//_________________meter tarjetas__________________________________________________________________________________
	public boolean MaterTarjetas(int noTarjetas) {
		if( cerrada) {
			msg="La billetera esta cerrada";
			return false;
		}
		if( this.noTarjetas + noTarjetas > maxTarjetas) {
			msg="No ha capacidad para las tarjetas";
			return false;
		}
		this.noTarjetas+=noTarjetas;
		msg="Tarjetas almacenadas correctamente";
		return true;
	}

	//_________________sacar tarjetas__________________________________________________________________________________
	public boolean SacarTarjetas(int noTarjetas) {
		if( cerrada) {
			msg="La billetera se encuentra cerrada";
			return false;
		}
		if( noTarjetas > this.noTarjetas ) {
			msg="No hay subientes tarjetas en la billetera";
			return false;
		}
		this.noTarjetas-=noTarjetas;
		msg="Extraction de tarjetas exitosa";
		return true;
	}

	//_________________contar dinero__________________________________________________________________________________
	public int contarDinero(int dineroTotal)
	{

	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getMaxBilletes() {
		return maxBilletes;
	}
	public void setMaxBilletes(int maxBilletes) {
		this.maxBilletes = maxBilletes;
	}
	public int getMaxTarjetas() {
		return maxTarjetas;
	}
	public void setMaxTarjetas(int maxTarjetas) {
		this.maxTarjetas = maxTarjetas;
	}
	public int getNoBilletes() {
		return noBilletes;
	}
	public void setNoBilletes(int noBilletes) {
		this.noBilletes = noBilletes;
	}
	public int getNoTarjetas() {
		return noTarjetas;
	}
	public void setNoTarjetas(int noTarjetas) {
		this.noTarjetas = noTarjetas;
	}
	public boolean isCerrada() {
		return cerrada;
	}
	public void setCerrada(boolean cerrada) {
		this.cerrada = cerrada;
	}
	public String getMsg() {
		return msg;
	}
}
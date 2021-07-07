import React from 'react'
import { DataGrid, GridColDef, GridValueGetterParams } from '@material-ui/data-grid';
import { makeStyles } from '@material-ui/core/styles';
import Modal from '@material-ui/core/Modal';
import { Fragment } from 'react';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';



    
const Table = () => {
    /* -- Inicio Definición de la Tabla -- */
    const columns = [
        { field: 'id', headerName: 'ID', width: 150 },
        {
          field: 'title',
          headerName: 'Título',
          width: 500,
          editable: true,
        },
        {
          field: 'price',
          headerName: 'Precio',
          type: 'number',
          valueFormatter: ({ value }) => currencyFormatter.format(Number(value)),
          width: 150,
          editable: true,
        },
        {
            field: 'currency_id',
            headerName: 'Moneda',
            width: 150,
            editable: true,
          },
        {
          field: 'available_quantity',
          headerName: 'Stock',
          type: 'number',
          width: 150,
          editable: true,
        },
          {
            field: 'condition',
            headerName: 'Condición',
            width: 150,
            editable: true,
          },
          {
            field: 'string',
            headerName: 'Acción',
            width: 150,
            renderCell: (params) => (
                <button onClick={(e) => verDetalle(e,params.row)} className="btn btn-success" style={{fontFamily:'Signika', border:'none', backgroundColor:'#ee5931'}}>
                  Ver Detalle
                </button>
            ),
          },
        ];
    
    const currencyFormatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
        });
    
    const [rows,setData] = React.useState([])
    const [query,setQuery] = React.useState('')
    const [titulo,setTitle] = React.useState('')
    const [detalle, setDetalle] = React.useState('');
    /* -- Fin Definición de la Tabla -- */


    const buscarProductos = (e) =>{
        e.preventDefault();
        setTitle(query)
       
        fetch("http://localhost:8080/api/search?query="+query)
        .then(resp=>resp.json())
        .then(resp=>{
        setData(resp);
        })
        
    }

    /* ---- Inicio Ver Detalle ---- */
    const [open, setOpen] = React.useState(false);

    const handleClose = () => {
        setOpen(false);
    };
    /* ---- Fin Ver Detalle ---- */

    const verDetalle = (e,params) =>{
        e.preventDefault();
        setOpen(true);
        setDetalle(params);
        debugger;
        
    }



    return (
        <Fragment>
         <div className="col-md-12">
           <nav className="navbar navbar-dark " style={{ background:"#85c24d" }}>
           <div className="container-fluid">
               <img src="https://utel-carreras.mx/s/utel/assets/img/logo-utel-white.svg" alt="" />
           <form className="d-flex">
                    <input className="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar" 
                        onChange={ (e) => setQuery(e.target.value)}/>
                    <button onClick={buscarProductos} className="btn btn-outline-light" type="submit">Buscar</button>
                </form>
            </div>
            </nav>
           
          
        </div>   
        <div className="col-md-12">
            <img style={{ width: '15em' }} src="https://x.utel.edu.mx/repositorios/uploads/2020/01/utelX_logo-1.png" alt="" />
        </div>
        <div style={{ height: 550, width: '100%' }}>
        <DataGrid
            rows={rows}
            columns={columns}
            pageSize={30}
            disableSelectionOnClick
        />
        </div>

        <div>
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
                maxWidth={"xl"}
               
            >
                <DialogTitle className="tituloModalDetalle" id="alert-dialog-title">
                    <h2>Descripción del producto</h2>
                    </DialogTitle>
                <DialogContent >
                <DialogContentText id="alert-dialog-description">
                    <div className="col-md-12 row">
                    <div className="col-md-5">
                        <img className="imgDetalle" src={detalle.thumbnail} alt="" />
                    </div>
                    <div className="col-md-7">
                        <label className="labelDetalle">{detalle.condition}</label>
                        <br/>
                        <h3 className="tituloDetalle">{detalle.title}</h3>
                        <br/>
                        <h4>{"Precio: $"+detalle.price}</h4>
                        <br/>
                        <label>{"Cantidad en Stock: "+detalle.available_quantity}</label>
                        
                    </div>
                    </div>
                </DialogContentText>
                </DialogContent>
                <DialogActions>
                <Button onClick={handleClose} color="primary" autoFocus style={{backgroundColor: '#ee5931', color: 'white',fontFamily: 'Signika'}}>
                    Cerrar
                </Button>
                </DialogActions>
            </Dialog>
        </div>
        </Fragment>
    )
}

export default Table

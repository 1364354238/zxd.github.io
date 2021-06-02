

# numpy和tensor之间的转换
---

```python
 num_tenor=torch.ones(2,3)
 num_numpy=np.ones((2,3))
```

- 将tensor转换为numpy,二者共用存储空间

```python
num_tenor2numpy=num_tensor.numpy()
``` 

- 将numpy转换为tensor,共用存储空间

```python
num_numpy2tentor=torch.from_numpy(num_numpy)
```

- 不共享内存，相当于重构一个tensor

```python
num2tensor=torch.tensor(num_numpy)
```

- tensor -> cuda tensor

```python
if(torch.cuda.is_available()):
  device=torch.device('cuda')
  num_tensor=num.tensor.to(device)
```

-cuda tensor->numpy,先要将数据移到CPU上

```python
cuda2numpy=num_tensor.cpu().numpy()
```




